package com.ezadmin.modules.system.service;

import com.ezadmin.model.vo.MenuPermissionVO;
import com.ezadmin.modules.system.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单信息表 服务类
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据角色id加载菜单
     *
     * @param roleIds roleIds
     * @return List<MenuPermissionVO>
     */
    List<MenuPermissionVO> loadMenuPermByRoleIds(List<Long> roleIds);

 }
