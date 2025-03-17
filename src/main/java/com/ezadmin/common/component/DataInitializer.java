package com.ezadmin.common.component;

import com.ezadmin.common.cache.AdminCache;
import com.ezadmin.model.vo.MenuPermissionVO;
import com.ezadmin.model.vo.RoleDetailVO;
import com.ezadmin.modules.system.entity.Role;
import com.ezadmin.modules.system.service.IMenuService;
import com.ezadmin.modules.system.service.IRoleService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 基础数据缓存初始化
 * </p>
 *
 * @author 曹申阳
 * @since 2024-10-12 16:45:18
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final AdminCache adminCache;
    private final IRoleService roleService;
    private final IMenuService menuService;

    @PostConstruct
    private void init() {
        log.info("Starting data initialization...");
        try {
            // 初始化角色权限数据
            initRoleMenuPermission();
            log.info("Data initialization completed successfully.");
        } catch (Exception e) {
            log.error("Data initialization failed: ", e);
        }

    }

    private void initRoleMenuPermission() {
        log.info("Initializing role with menus permissions...");
        // 查询所有角色信息
        List<Role> allRoles = roleService.loadAllRoles();
        List<Long> roleIds = allRoles.stream().map(Role::getRoleId).collect(Collectors.toList());
        // 通过角色ID查询角色对应的菜单列表
        List<MenuPermissionVO> menuPermissionVOS = menuService.loadMenuPermByRoleIds(roleIds);
        // 根据角色ID分组  key - roleId, value - MenuPermissionVO
        Map<Long, List<MenuPermissionVO>> menuPermissionsMap = menuPermissionVOS.stream()
                .collect(Collectors.groupingBy(MenuPermissionVO::getRoleId));
        for (Role role : allRoles) {
            log.info("Processing role: {}", role.getRoleName());
            List<MenuPermissionVO> menuPermissions = menuPermissionsMap.get(role.getRoleId());
            // 如果角色没有分配权限，则跳过
            if (menuPermissions == null || menuPermissions.isEmpty()) {
                log.warn("No menuPermissions found for role: {}", role.getRoleName());
                continue;
            }
            // 将菜单权限信息存入Redis
            adminCache.cacheRoleMenuPermissions(role.getRoleLabel(), menuPermissions);
        }
        log.info("Role permissions initialization completed.");
    }
}
