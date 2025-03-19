package com.ezadmin.modules.system.service;

import com.ezadmin.model.dto.UserCreateDTO;
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

    void checkUsernameExists(String username);
}
