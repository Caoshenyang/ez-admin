package com.ezadmin.service;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.ezadmin.common.result.tree.TreeBuilder;
import com.ezadmin.model.dto.MenuCreateDTO;
import com.ezadmin.model.dto.MenuUpdateDTO;
import com.ezadmin.model.mpstruct.MsDeptMapper;
import com.ezadmin.model.mpstruct.MsMenuMapper;
import com.ezadmin.model.vo.DeptDetailVO;
import com.ezadmin.model.vo.MenuDetailVO;
import com.ezadmin.model.vo.MenuTreeVO;
import com.ezadmin.modules.system.entity.Menu;
import com.ezadmin.modules.system.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 类名: MenuManagementService
 * 功能描述: 菜单管理
 *
 * @author shenyang
 * @since 2025/3/20 16:20
 */
@Service
@RequiredArgsConstructor
public class MenuManagementService {

    private final IMenuService menuService;

    /**
     * 创建菜单
     * @param menuCreateDTO menuCreateDTO
     */
    public void createMenu(MenuCreateDTO menuCreateDTO) {
        // todo 校验菜单唯一性
        Menu menu = MsMenuMapper.INSTANCE.menuCreateDTO2Menu(menuCreateDTO);
        menuService.save(menu);
    }

    /**
     * 更新菜单
     * @param menuUpdateDTO menuUpdateDTO
     */
    public void updateMenu(MenuUpdateDTO menuUpdateDTO) {
        Menu menu = MsMenuMapper.INSTANCE.menuUpdateDTO2Menu(menuUpdateDTO);
        menuService.updateById(menu);
    }

    /**
     * 删除菜单
     * @param menuId menuId
     */
    public void deleteMenu(Long menuId) {
        // todo 删除菜单前校验 如果有自己菜单，并且被引用，则不允许删除
        menuService.removeById(menuId);
    }

    /**
     * 根据菜单id获取菜单详情
     * @param menuId menuId
     * @return MenuDetailVO
     */
    public MenuDetailVO getMenuDetailById(Long menuId) {
        return Optional.ofNullable(menuService.getById(menuId))
                .map(MsMenuMapper.INSTANCE::menu2MenuDetailVO)
                .orElse(null);
    }

    /**
     * 根据角色id加载菜单
     * @param menuId menuId
     * @return MenuDetailVO
     */
    public MenuDetailVO getMenuById(Long menuId) {
        return Optional.ofNullable(menuService.getById(menuId))
                .map(MsMenuMapper.INSTANCE::menu2MenuDetailVO)
                .orElse(null);
    }

    /**
     * 查询菜单树
     * @return List<MenuTreeVO>
     */
    public List<MenuTreeVO> findMenuTree() {
        return Optional.ofNullable(menuService.list())
                .filter(CollectionUtils::isNotEmpty)
                .map(MsMenuMapper.INSTANCE::menu2MenuTreeVOs)
                .map(TreeBuilder::buildTree)
                .orElseGet(List::of);
    }


}
