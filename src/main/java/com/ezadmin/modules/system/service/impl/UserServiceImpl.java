package com.ezadmin.modules.system.service.impl;

import com.ezadmin.common.exception.ExceptionEnum;
import com.ezadmin.common.exception.EzAdminException;
import com.ezadmin.common.utils.PasswordEncoderUtil;
import com.ezadmin.model.dto.UserCreateDTO;
import com.ezadmin.model.mpstruct.MsUserMapper;
import com.ezadmin.modules.system.entity.User;
import com.ezadmin.modules.system.mapper.UserMapper;
import com.ezadmin.modules.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User selectUserByUsername(String username) {
        return lambdaQuery()
                .select(User::getUserId, User::getUsername, User::getPassword, User::getNickname, User::getAvatar)
                .eq(User::getUsername, username).one();
    }

    /**
     * 校验用户名是否存在
     *
     * @param username 用户名
     */
    public void checkUsernameExists(String username) {
        boolean exists = lambdaQuery().eq(User::getUsername, username).exists();
        if (exists) {
            throw new EzAdminException(ExceptionEnum.USERNAME_EXISTS);
        }
    }

}
