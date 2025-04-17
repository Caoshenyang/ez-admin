package com.ezadmin.modules.system.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ezadmin.model.query.UserQuery;
import com.ezadmin.model.vo.UserListVO;
import com.ezadmin.modules.system.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
public interface UserMapper extends BaseMapper<User> {

    Page<UserListVO> findPage(Page<UserListVO> page, UserQuery search);
}

