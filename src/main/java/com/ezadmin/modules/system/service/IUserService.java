package com.ezadmin.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ezadmin.model.dto.UserCreateDTO;
import com.ezadmin.model.query.UserQuery;
import com.ezadmin.model.vo.UserListVO;
import com.ezadmin.modules.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
public interface IUserService extends IService<User> {


    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return User
     */
    User selectUserByUsername(String username);

    /**
     * 检查用户名是否存在
     * @param username 用户名
     */
    void checkUsernameExists(String username);

    void findPage(Page<UserListVO> page, UserQuery search);
}
