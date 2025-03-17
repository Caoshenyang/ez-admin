package com.ezadmin.modules.system.mapper;

import com.ezadmin.modules.system.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectRoleListByUserId(Long userId);
}

