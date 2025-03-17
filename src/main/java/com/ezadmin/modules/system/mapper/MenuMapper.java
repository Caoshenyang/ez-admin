package com.ezadmin.modules.system.mapper;

import com.ezadmin.model.vo.MenuPermissionVO;
import com.ezadmin.modules.system.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


/**
 * <p>
 * 菜单信息表 Mapper 接口
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<MenuPermissionVO> loadMenuPermByRoleIds(List<Long> roleIds);
}

