package com.ezadmin.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ezadmin.modules.system.entity.RoleMenuRelation;
import com.ezadmin.modules.system.mapper.RoleMenuRelationMapper;
import com.ezadmin.modules.system.service.IRoleMenuRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色菜单关联表 服务实现类
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
@Service
public class RoleMenuRelationServiceImpl extends ServiceImpl<RoleMenuRelationMapper, RoleMenuRelation> implements IRoleMenuRelationService {

    @Override
    public List<String> findMenusByRoleId(Long roleId) {

        return lambdaQuery().select(RoleMenuRelation::getMenuId)
                .eq(RoleMenuRelation::getRoleId, roleId)
                .list()
                .stream()
                .map(RoleMenuRelation::getMenuId)
                .map(Object::toString)
                .collect(Collectors.toList());

    }

    @Override
    public void removeByRoleId(Long roleId) {
        lambdaUpdate().eq(RoleMenuRelation::getRoleId, roleId).remove();
    }
}
