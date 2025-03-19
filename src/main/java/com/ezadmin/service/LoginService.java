package com.ezadmin.service;

import cn.dev33.satoken.stp.SaLoginConfig;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.ezadmin.common.cache.AdminCache;
import com.ezadmin.common.constants.UserConstants;
import com.ezadmin.common.exception.ExceptionEnum;
import com.ezadmin.common.exception.EzAdminException;
import com.ezadmin.common.result.tree.TreeBuilder;
import com.ezadmin.common.utils.PasswordEncoderUtil;
import com.ezadmin.model.dto.LoginDTO;
import com.ezadmin.model.mpstruct.MsMenuMapper;
import com.ezadmin.model.vo.MenuPermissionVO;
import com.ezadmin.model.vo.RouterTreeVO;
import com.ezadmin.model.vo.TokenInfoVO;
import com.ezadmin.model.vo.UserInfoVO;
import com.ezadmin.modules.system.entity.Role;
import com.ezadmin.modules.system.entity.User;
import com.ezadmin.modules.system.entity.UserRoleRelation;
import com.ezadmin.modules.system.service.IRoleService;
import com.ezadmin.modules.system.service.IUserRoleRelationService;
import com.ezadmin.modules.system.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class LoginService {

    private final AdminCache adminCache;
    private final IUserService userService;
    private final IRoleService roleService;
    private final IUserRoleRelationService userRoleRelationService;

    /**
     * 登录返回 token 信息
     * @param loginDTO 登录信息
     * @return TokenInfoVO
     */
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

    /**
     * 初始化管理员账号
     */
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

    /**
     * 校验是否已初始化管理员账号
     */
    public void checkInitAdminAccount() {
        User user = userService.selectUserByUsername(UserConstants.ADMIN_USER_NAME);
        if (user != null) {
            throw new EzAdminException(ExceptionEnum.ADMIN_ACCOUNT_INITIALIZED);
        }
    }



    /**
     * 获取用户信息
     * @return UserInfoVO
     */
    public UserInfoVO getUserInfo() {
        long loginId = StpUtil.getLoginIdAsLong();
        String username = (String) StpUtil.getExtra("username");
        String nickname = (String) StpUtil.getExtra("nickname");
        String avatar = (String) StpUtil.getExtra("avatar");
        List<String> permissionList = StpUtil.getPermissionList(loginId);
        List<String> roleList = StpUtil.getRoleList(loginId);
        List<MenuPermissionVO> menuByRoleLabels = adminCache.getMenuByRoleLabels(roleList);
        List<RouterTreeVO> routerTreeVOS = MsMenuMapper.INSTANCE.menuPermissionVO2RouterTreeVOs(menuByRoleLabels);
        List<RouterTreeVO> routers = TreeBuilder.buildTree(routerTreeVOS);
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setPermissions(permissionList);
        userInfoVO.setRouters(routers);
        userInfoVO.setUserId(loginId);
        userInfoVO.setUsername(username);
        userInfoVO.setNickname(nickname);
        userInfoVO.setAvatar(avatar);
        return userInfoVO;
    }

    /**
     * 退出登录
     */
    public void logout() {
        StpUtil.logout();
    }
}
