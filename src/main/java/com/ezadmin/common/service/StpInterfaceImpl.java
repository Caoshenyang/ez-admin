package com.ezadmin.common.service;

import cn.dev33.satoken.stp.StpInterface;

import com.ezadmin.common.component.RedisCache;
import com.ezadmin.common.constants.RedisKey;
import com.ezadmin.model.vo.MenuPermissionVO;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 自定义权限加载接口实现类
 * </p>
 *
 * @author shenyang
 * @since 2024-12-02 15:40:09
 */
@RequiredArgsConstructor
public class StpInterfaceImpl implements StpInterface {

    private final RedisCache redisCache;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 获取用户角色
        List<String> roleLabelList = getRoleList(loginId, loginType);
        // 从缓存中获取角色权限
        if (roleLabelList.isEmpty()) {
            return new ArrayList<>();
        }
        Set<MenuPermissionVO> menuPermissionVOSet = new HashSet<>();
        for (String roleLabelItem : roleLabelList) {
            List<MenuPermissionVO> roleMenu = getMenuByRoleLabel(roleLabelItem);
            menuPermissionVOSet.addAll(roleMenu);
        }
        return menuPermissionVOSet.stream().map(MenuPermissionVO::getMenuPerm).toList();
    }

    private List<MenuPermissionVO> getMenuByRoleLabel(String roleLabel) {
        String roleKey = RedisKey.ROLE_MENU + roleLabel;
        return redisCache.getCacheObject(roleKey);
    }

    /**
     * 获取角色列表
     *
     * @param loginId   用户id
     * @param loginType 登录类型
     * @return List<String>
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        String userRolesKey = RedisKey.USER_ROLE + loginId;
        if (Boolean.TRUE.equals(redisCache.hasKey(userRolesKey))) {
            return redisCache.getCacheObject(userRolesKey);
        }
        return List.of();
    }
}
