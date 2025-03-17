package com.ezadmin.modules.system.service.impl;

import com.ezadmin.model.vo.MenuPermissionVO;
import com.ezadmin.modules.system.entity.Menu;
import com.ezadmin.modules.system.mapper.MenuMapper;
import com.ezadmin.modules.system.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单信息表 服务实现类
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public List<MenuPermissionVO> loadMenuPermByRoleIds(List<Long> roleIds) {
        return baseMapper.loadMenuPermByRoleIds(roleIds);

    }
}
