package com.ezadmin.modules.system.service.impl;

import com.ezadmin.modules.system.entity.Role;
import com.ezadmin.modules.system.mapper.RoleMapper;
import com.ezadmin.modules.system.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<Role> selectRoleListByUserId(Long userId) {
        return baseMapper.selectRoleListByUserId(userId);
    }
}
