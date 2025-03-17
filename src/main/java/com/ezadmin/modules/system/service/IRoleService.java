package com.ezadmin.modules.system.service;

import com.ezadmin.modules.system.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
public interface IRoleService extends IService<Role> {

    /**
     * 根据用户ID查询角色列表
     * @param userId 用户ID
     * @return List<Role>
     */
    List<Role> selectRoleListByUserId(Long userId);
}
