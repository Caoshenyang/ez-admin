package com.ezadmin.modules.system.service.impl;

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

}
