package com.ezadmin.service;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.ezadmin.common.result.tree.TreeBuilder;
import com.ezadmin.model.dto.DeptCreateDTO;
import com.ezadmin.model.dto.DeptUpdateDTO;
import com.ezadmin.model.mpstruct.MsDeptMapper;
import com.ezadmin.model.vo.DeptDetailVO;
import com.ezadmin.model.vo.DeptTreeVO;
import com.ezadmin.modules.system.entity.Dept;
import com.ezadmin.modules.system.service.IDeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 类名: DeptManagementService
 * 功能描述: 部门管理
 *
 * @author shenyang
 * @since 2025/3/19 17:40
 */
@Service
@RequiredArgsConstructor
public class DeptManagementService {

    private final IDeptService deptService;

    public void createDept(DeptCreateDTO deptCreateDTO) {
        // todo 一些校验
        Dept dept = MsDeptMapper.INSTANCE.deptCreateDTO2Dept(deptCreateDTO);
        deptService.save(dept);
    }

    public void updateDept(DeptUpdateDTO deptUpdateDTO) {
        Dept dept = MsDeptMapper.INSTANCE.deptUpdateDTO2Dept(deptUpdateDTO);
        deptService.updateById(dept);

    }

    public void deleteDept(Long deptId) {
        deptService.removeById(deptId);
    }

    public void deleteBatchDept(List<Long> deptIdList) {
        deptService.removeBatchByIds(deptIdList);
    }

    public DeptDetailVO getDeptById(Long deptId) {
        return Optional.ofNullable(deptService.getById(deptId))
                .map(MsDeptMapper.INSTANCE::dept2DeptDetailDTO)
                .orElse(null);
    }

    public List<DeptTreeVO> findDeptTree() {
        return Optional.ofNullable(deptService.list())
                .filter(CollectionUtils::isNotEmpty)
                .map(MsDeptMapper.INSTANCE::dept2DeptTreeVOs)
                .map(TreeBuilder::buildTree)
                .orElseGet(List::of);
    }
}
