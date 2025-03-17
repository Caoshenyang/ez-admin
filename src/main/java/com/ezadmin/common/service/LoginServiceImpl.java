package com.ezadmin.common.service;

import cn.dev33.satoken.stp.SaLoginConfig;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.ezadmin.common.cache.AdminCache;
import com.ezadmin.common.constants.UserConstants;
import com.ezadmin.common.exception.ExceptionEnum;
import com.ezadmin.common.exception.EzAdminException;
import com.ezadmin.common.utils.PasswordEncoderUtil;
import com.ezadmin.model.dto.LoginDTO;
import com.ezadmin.model.mpstruct.MsRoleMapper;
import com.ezadmin.model.vo.RoleDetailVO;
import com.ezadmin.model.vo.TokenInfoVO;
import com.ezadmin.modules.system.entity.Role;
import com.ezadmin.modules.system.entity.User;
import com.ezadmin.modules.system.entity.UserRoleRelation;
import com.ezadmin.modules.system.service.IRoleService;
import com.ezadmin.modules.system.service.IUserRoleRelationService;
import com.ezadmin.modules.system.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名: LoginServiceImpl
 * 功能描述: 登录业务
 *
 * @author shenyang
 * @since 2025/3/17 9:47
 */
@Service
@RequiredArgsConstructor
public class LoginServiceImpl {

    private final AdminCache adminCache;
    private final IUserService userService;
    private final IRoleService roleService;
    private final IUserRoleRelationService userRoleRelationService;

    public TokenInfoVO login(LoginDTO loginDTO) {

        User user = userService.selectUserByUsername(loginDTO.getUsername());
        if (user == null) {
            throw new EzAdminException(ExceptionEnum.USERNAME_NOT_EXISTS);
        }
        if (!PasswordEncoderUtil.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new EzAdminException(ExceptionEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        // 用户验证
        StpUtil.login(user.getUserId(), SaLoginConfig
                .setExtra("username", user.getUsername())
                .setExtra("nickname", user.getNickname())
                .setExtra("avatar", user.getAvatar()));

        // 登录成功, 缓存用户角色信息，避免每次查询数据库
        List<Role> roles = roleService.selectRoleListByUserId(user.getUserId());
        List<String> roleLabels = roles.stream().map(Role::getRoleLabel).collect(Collectors.toList());
        adminCache.cacheUserRoles(user.getUserId(), roleLabels);

        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        TokenInfoVO tokenInfoVO = new TokenInfoVO();
        tokenInfoVO.setTokenName(tokenInfo.getTokenName());
        tokenInfoVO.setTokenValue(tokenInfo.getTokenValue());
        return tokenInfoVO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void initializeAdminAccount() {

        // 校验是否已初始化管理员账号
        checkInitAdminAccount();

        User adminUser = new User();
        adminUser.setUsername(UserConstants.ADMIN_USER_NAME);
        adminUser.setPassword(PasswordEncoderUtil.encode(UserConstants.ADMIN_USER_PASSWORD));
        adminUser.setNickname(UserConstants.ADMIN_USER_NAME);
        adminUser.setCreateBy("init");
        adminUser.setUpdateBy("init");
        // 保存用户
        userService.save(adminUser);
        Role adminRole = new Role();
        adminRole.setRoleName(UserConstants.ADMIN_ROLE_NAME);
        adminRole.setRoleLabel(UserConstants.ADMIN_ROLE_KEY);
        adminRole.setCreateBy("init");
        adminRole.setUpdateBy("init");
        roleService.save(adminRole);
        UserRoleRelation adminUserRoleRelation = new UserRoleRelation();
        adminUserRoleRelation.setRoleId(adminUser.getUserId());
        adminUserRoleRelation.setUserId(adminRole.getRoleId());
        userRoleRelationService.save(adminUserRoleRelation);
    }

    public void checkInitAdminAccount() {
        User user = userService.selectUserByUsername(UserConstants.ADMIN_USER_NAME);
        if (user != null) {
            throw new EzAdminException(ExceptionEnum.ADMIN_ACCOUNT_INITIALIZED);
        }
    }


}
