package com.ezadmin.api;

import com.ezadmin.common.result.R;
import com.ezadmin.model.dto.DeptCreateDTO;
import com.ezadmin.model.dto.DeptUpdateDTO;
import com.ezadmin.model.vo.DeptDetailVO;
import com.ezadmin.model.vo.DeptTreeVO;
import com.ezadmin.service.DeptManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 部门信息表 前端控制器
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
@Tag(name = "部门管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/dept")
public class DeptController {

    private final DeptManagementService deptManagementService;


    @Operation(summary = "新增")
    @PostMapping("/create")
    public R<String> createDept(@RequestBody DeptCreateDTO deptCreateDTO) {
        deptManagementService.createDept(deptCreateDTO);
        return R.ok();
    }

    @Operation(summary = "更新")
    @PostMapping("/update")
    public R<String> updateDept(@RequestBody DeptUpdateDTO deptUpdateDTO) {
        deptManagementService.updateDept(deptUpdateDTO);
        return R.ok();
    }

    @Operation(summary = "删除")
    @DeleteMapping("/delete/{deptId}")
    public R<String> deleteDept(@PathVariable("deptId") Long deptId) {
        deptManagementService.deleteDept(deptId);
        return R.ok();
    }


    @Operation(summary = "批量删除", description = "批量删除")
    @DeleteMapping("/delete/batch")
    public R<String> deleteBatchDept(@RequestBody List<Long> deptIdList) {
        deptManagementService.deleteBatchDept(deptIdList);
        return R.ok();
    }


    @Operation(summary = "根据ID查询部门", description = "根据ID查询部门")
    @GetMapping("/{deptId}")
    public R<DeptDetailVO> getDeptById(@PathVariable("deptId") Long deptId) {
        return R.ok(deptManagementService.getDeptById(deptId));
    }

    @Operation(summary = "查询部门列表（树形）")
    @PostMapping(value = "/tree")
    public R<List<DeptTreeVO>> findDeptTree() {
        return R.ok(deptManagementService.findDeptTree());
    }

}

