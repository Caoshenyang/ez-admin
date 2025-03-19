package com.ezadmin.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ezadmin.common.constants.UserConstants;
import com.ezadmin.common.exception.ExceptionEnum;
import com.ezadmin.common.exception.EzAdminException;
import com.ezadmin.common.result.page.PageQuery;
import com.ezadmin.common.result.page.PageVO;
import com.ezadmin.common.utils.PasswordEncoderUtil;
import com.ezadmin.model.dto.UserCreateDTO;
import com.ezadmin.model.dto.UserUpdateDTO;
import com.ezadmin.model.mpstruct.MsUserMapper;
import com.ezadmin.model.query.UserQuery;
import com.ezadmin.model.vo.UserListVO;
import com.ezadmin.modules.system.entity.User;
import com.ezadmin.modules.system.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

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


    /**
     * 新增用户
     *
     * @param userCreateDTO userCreateDTO
     */
    public void createUser(UserCreateDTO userCreateDTO) {
        userService.checkUsernameExists(userCreateDTO.getUsername());
        // 密码加密
        userCreateDTO.setPassword(PasswordEncoderUtil.encode(userCreateDTO.getPassword()));
        User user = MsUserMapper.INSTANCE.UserCreateDTO2User(userCreateDTO);
        userService.save(user);
    }

    /**
     * 修改用户
     *
     * @param userUpdateDTO userUpdateDTO
     */
    public void updateUser(UserUpdateDTO userUpdateDTO) {
        User user = MsUserMapper.INSTANCE.UserUpdateDTO2User(userUpdateDTO);
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
        Page<User> page = userQuery.toMpPage();
        UserQuery search = userQuery.getSearch();
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .eq(StrUtil.isNotBlank(search.getUsername()), User::getUsername, search.getUsername())
                .or()
                .like(StrUtil.isNotBlank(search.getNickname()), User::getNickname, search.getNickname());
        // 查询
        userService.page(page, queryWrapper);
        // 将 Mybatis Plus 的 Page 对象 转换为 PageVO
        return PageVO.of(page, UserListVO.class);
    }
}
