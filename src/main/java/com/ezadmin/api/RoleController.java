package com.ezadmin.api;

import com.ezadmin.common.result.R;
import com.ezadmin.common.result.page.PageQuery;
import com.ezadmin.common.result.page.PageVO;
import com.ezadmin.model.dto.RoleCreateDTO;
import com.ezadmin.model.dto.RoleUpdateDTO;
import com.ezadmin.model.vo.RoleDetailVO;
import com.ezadmin.model.vo.RoleListVO;
import com.ezadmin.service.RoleManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
@Tag(name = "角色管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/role")
public class RoleController {
    private final RoleManagementService roleManagementService;

    @Operation(summary = "添加角色", description = "添加角色")
    @PostMapping("/save")
    public R<String> createRole(@RequestBody RoleCreateDTO roleCreateDTO) {
        roleManagementService.createRole(roleCreateDTO);
        return R.ok();
    }

    @Operation(summary = "编辑角色", description = "编辑角色")
    @PostMapping("/update")
    public R<String> updateRole(@RequestBody RoleUpdateDTO roleUpdateDTO) {
        roleManagementService.updateRole(roleUpdateDTO);
        return R.ok();
    }

    @Operation(summary = "删除角色", description = "根据ID删除角色")
    @Parameter(name = "roleId", description = "角色ID")
    @DeleteMapping("/remove/{roleId}")
    public R<String> removeRole(@PathVariable Long roleId) {
        roleManagementService.removeRole(roleId);
        return R.ok();
    }

    @Operation(summary = "条件分页查询", description = "条件分页查询")
    @PostMapping("/page")
    public R<PageVO<RoleListVO>> findPage(@RequestBody PageQuery<?> query) {
        return R.ok(roleManagementService.findPage(query));
    }

    @Operation(summary = "根据ID查询角色", description = "根据ID查询角色")
    @GetMapping("/getRoleById/{roleId}")
    public R<RoleDetailVO> findRoleById(@PathVariable Long roleId) {
        return R.ok(roleManagementService.getRoleById(roleId));
    }


}
