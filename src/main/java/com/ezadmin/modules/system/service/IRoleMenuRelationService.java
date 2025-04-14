package com.ezadmin.modules.system.service;

import com.ezadmin.modules.system.entity.RoleMenuRelation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色菜单关联表 服务类
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
public interface IRoleMenuRelationService extends IService<RoleMenuRelation> {

    List<String> findMenusByRoleId(Long roleId);

    void removeByRoleId(Long roleId);
}
