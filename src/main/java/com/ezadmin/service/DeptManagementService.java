package com.ezadmin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.ezadmin.common.result.tree.TreeBuilder;
import com.ezadmin.model.dto.DeptCreateDTO;
import com.ezadmin.model.dto.DeptUpdateDTO;
import com.ezadmin.model.mpstruct.MsDeptMapper;
import com.ezadmin.model.query.DeptQuery;
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

    /**
     * 部门创建
     *
     * @param deptCreateDTO deptCreateDTO
     */
    public void createDept(DeptCreateDTO deptCreateDTO) {
        // todo 一些校验
        Dept dept = MsDeptMapper.INSTANCE.deptCreateDTO2Dept(deptCreateDTO);
        deptService.save(dept);
    }

    /**
     * 部门更新
     *
     * @param deptUpdateDTO deptUpdateDTO
     */
    public void updateDept(DeptUpdateDTO deptUpdateDTO) {
        Dept dept = MsDeptMapper.INSTANCE.deptUpdateDTO2Dept(deptUpdateDTO);
        deptService.updateById(dept);

    }

    /**
     * 根据ID删除部门
     *
     * @param deptId deptId
     */
    public void deleteDept(Long deptId) {
        deptService.removeById(deptId);
    }

    /**
     * 批量删除部门
     *
     * @param deptIdList deptIdList
     */
    public void deleteBatchDept(List<Long> deptIdList) {
        deptService.removeBatchByIds(deptIdList);
    }

    /**
     * 根据ID查询部门详情
     *
     * @param deptId deptId
     * @return DeptDetailVO
     */
    public DeptDetailVO getDeptById(Long deptId) {
        return Optional.ofNullable(deptService.getById(deptId))
                .map(MsDeptMapper.INSTANCE::dept2DeptDetailDTO)
                .orElse(null);
    }

    /**
     * 查询部门树
     *
     * @return List<DeptTreeVO>
     */
    public List<DeptTreeVO> findDeptTree(DeptQuery deptQuery) {
        // 选择部门数据 只筛选出启用的部门
        LambdaQueryWrapper<Dept> queryWrapper = new LambdaQueryWrapper<Dept>()
                .orderByAsc(Dept::getDeptSort);
        // 直接使用函数式引用构建查询
        if (StringUtils.isNotBlank(deptQuery.getKeyword())) {
            queryWrapper.and(wrapper -> {
                for (SFunction<Dept, String> field : deptQuery.getKeywordSearchFields()) {
                    wrapper.or().like(field, deptQuery.getKeyword());
                }
            });
        }
        // 高级查询



        return Optional.ofNullable(deptService.list(queryWrapper))
                .filter(CollectionUtils::isNotEmpty)
                .map(MsDeptMapper.INSTANCE::dept2DeptTreeVOs)
                .map(TreeBuilder::buildTree)
                .orElseGet(List::of);
    }

    public List<DeptTreeVO> findDeptTreeSelect() {
        // 选择部门数据 只筛选出启用的部门
        LambdaQueryWrapper<Dept> queryWrapper = new LambdaQueryWrapper<Dept>()
                .select(Dept::getDeptId, Dept::getDeptName, Dept::getParentId, Dept::getAncestors)
                .eq(Dept::getStatus, 1)
                .orderByAsc(Dept::getDeptSort);

        return Optional.ofNullable(deptService.list(queryWrapper))
                .filter(CollectionUtils::isNotEmpty)
                .map(MsDeptMapper.INSTANCE::dept2DeptTreeVOs)
                .map(TreeBuilder::buildTree)
                .orElseGet(List::of);
    }
}
