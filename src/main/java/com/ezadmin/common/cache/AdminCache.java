package com.ezadmin.common.cache;

import com.ezadmin.common.component.RedisCache;
import com.ezadmin.common.constants.RedisKey;
import com.ezadmin.model.vo.MenuPermissionVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 类名: AdminCache
 * 功能描述: ezadmin 后台缓存相关操作
 *
 * @author shenyang
 * @since 2025/3/17 16:25
 */
@Component
@RequiredArgsConstructor
public class AdminCache {

    private final RedisCache redisCache;
    // todo 暂时放这里，后续优化
    private static final Long EXPIRE_TIME = 60 * 60 * 24 * 30L; // 30 天

    /**
     * 缓存用户角色
     *
     * @param userId     用户ID
     * @param roleLabels 用户角色标识
     */
    public void cacheUserRoles(Long userId, List<String> roleLabels) {
        redisCache.setCacheObject(RedisKey.USER_ROLE + userId, roleLabels, EXPIRE_TIME, TimeUnit.SECONDS);
    }

    /**
     * 缓存角色菜单权限
     *
     * @param roleLabel   角色标识
     * @param permissions 菜单权限集合
     */
    public void cacheRoleMenuPermissions(String roleLabel, List<MenuPermissionVO> permissions) {
        redisCache.setCacheObject(RedisKey.ROLE_MENU + roleLabel, permissions, EXPIRE_TIME, TimeUnit.SECONDS);
    }
}
