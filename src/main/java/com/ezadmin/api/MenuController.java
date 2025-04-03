package com.ezadmin.api;

import com.ezadmin.common.result.R;
import com.ezadmin.model.dto.MenuCreateDTO;
import com.ezadmin.model.dto.MenuUpdateDTO;
import com.ezadmin.model.vo.MenuDetailVO;
import com.ezadmin.model.vo.MenuTreeVO;
import com.ezadmin.service.MenuManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单信息表 前端控制器
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
@Tag(name = "菜单管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/menu")
public class MenuController {

    private final MenuManagementService menuManagementService;


    @Operation(summary = "新增菜单", description = "新增菜单")
    @PostMapping("/save")
    public R<String> createMenu(@RequestBody MenuCreateDTO menuCreateDTO) {
        menuManagementService.createMenu(menuCreateDTO);
        return  R.ok();
    }

    @Operation(summary = "编辑菜单", description = "编辑菜单")
    @PostMapping("/update")
    public R<String> updateMenu(@RequestBody MenuUpdateDTO menuUpdateDTO) {
        menuManagementService.updateMenu(menuUpdateDTO);
        return  R.ok();
    }

    @Operation(summary = "删除")
    @DeleteMapping("/delete/{menuId}")
    public R<String> deleteMenu(@PathVariable("menuId") Long menuId) {
        menuManagementService.deleteMenu(menuId);
        return R.ok();
    }

    @Operation(summary = "根据ID查询菜单", description = "根据ID查询菜单")
    @GetMapping("/{menuId}")
    public R<MenuDetailVO> getMenuById(@PathVariable("menuId") Long menuId) {
        return R.ok(menuManagementService.getMenuById(menuId));
    }
    @Operation(summary = "查询菜单列表（树）", description = "查询菜单列表（树）")
    @PostMapping("/tree")
    public R<List<MenuTreeVO>> findMenuTree() {
        return R.ok(menuManagementService.findMenuTree());
    }
}
