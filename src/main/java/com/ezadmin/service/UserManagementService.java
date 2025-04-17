package com.ezadmin.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ezadmin.common.result.page.PageQuery;
import com.ezadmin.common.result.page.PageVO;
import com.ezadmin.common.utils.PasswordEncoderUtil;
import com.ezadmin.model.dto.UserCreateDTO;
import com.ezadmin.model.dto.UserUpdateDTO;
import com.ezadmin.model.mpstruct.MsUserMapper;
import com.ezadmin.model.query.UserQuery;
import com.ezadmin.model.vo.RoleDetailVO;
import com.ezadmin.model.vo.UserDetailVO;
import com.ezadmin.model.vo.UserListVO;
import com.ezadmin.modules.system.entity.Role;
import com.ezadmin.modules.system.entity.User;
import com.ezadmin.modules.system.service.IRoleService;
import com.ezadmin.modules.system.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名: UserManagementService
 * 功能描述: 用户管理
 *
 * @author shenyang
 * @since 2025/3/19 15:42
 */
@Service
@RequiredArgsConstructor
public class UserManagementService {

    private final IUserService userService;
    private final IRoleService roleService;

    /**
     * 新增用户
     *
     * @param userCreateDTO userCreateDTO
     */
    public void createUser(UserCreateDTO userCreateDTO) {
        userService.checkUsernameExists(userCreateDTO.getUsername());
        // 密码加密
        userCreateDTO.setPassword(PasswordEncoderUtil.encode(userCreateDTO.getPassword()));
        User user = MsUserMapper.INSTANCE.userCreateDTO2User(userCreateDTO);
        userService.save(user);
    }

    /**
     * 修改用户
     *
     * @param userUpdateDTO userUpdateDTO
     */
    public void updateUser(UserUpdateDTO userUpdateDTO) {
        User user = MsUserMapper.INSTANCE.userUpdateDTO2User(userUpdateDTO);
        userService.updateById(user);
    }

    /**
     * 删除用户
     *
     * @param userId userId
     */
    public void deleteUser(Long userId) {
        userService.removeById(userId);
    }

    public PageVO<UserListVO> findPage(PageQuery<UserQuery> userQuery) {
        // 将查询对象 转换为 Mybatis Plus 的 Page 对象
        Page<UserListVO> page = userQuery.toMpPage();
        UserQuery search = userQuery.getSearch();
        // 查询
        userService.findPage(page,search);
        // 将 Mybatis Plus 的 Page 对象 转换为 PageVO
        return PageVO.of(page, UserListVO.class);
    }

    public UserDetailVO findUserById(Long userId) {
        User user = userService.getById(userId);
        UserDetailVO userDetailVO = MsUserMapper.INSTANCE.user2UserDetailVO(user);
        // 查询用户角色
        List<Role> roles = roleService.selectRoleListByUserId(user.getUserId());
        // 收集所有角色Id，并且转成字符串数组
        List<String> roleIds = roles.stream().map(role -> String.valueOf(role.getRoleId())).toList();
        userDetailVO.setRoleIds(roleIds);
        return userDetailVO;
    }
}
