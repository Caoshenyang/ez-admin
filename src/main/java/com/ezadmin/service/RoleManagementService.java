package com.ezadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ezadmin.common.result.page.PageQuery;
import com.ezadmin.common.result.page.PageVO;
import com.ezadmin.model.dto.RoleCreateDTO;
import com.ezadmin.model.dto.RoleUpdateDTO;
import com.ezadmin.model.mpstruct.MsRoleMapper;
import com.ezadmin.model.vo.RoleDetailVO;
import com.ezadmin.model.vo.RoleListVO;
import com.ezadmin.modules.system.entity.Role;
import com.ezadmin.modules.system.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 类名: RoleManagementService
 * 功能描述: 角色管理
 *
 * @author shenyang
 * @since 2025/3/19 17:17
 */
@Service
@RequiredArgsConstructor
public class RoleManagementService {

    private final IRoleService roleService;

    /**
     * 创建角色
     *
     * @param roleCreateDTO 角色创建参数
     */
    public void createRole(RoleCreateDTO roleCreateDTO) {
        // todo 校验角色名称唯一性
        Role role = MsRoleMapper.INSTANCE.roleCreateDTO2Role(roleCreateDTO);
        roleService.save(role);
    }

    public void updateRole(RoleUpdateDTO roleUpdateDTO) {
        // todo 校验角色名称唯一性
        Role role = MsRoleMapper.INSTANCE.roleUpdateDTO2Role(roleUpdateDTO);
        roleService.updateById(role);
    }

    public void removeRole(Long roleId) {
        // todo 1. 删除时判断角色是否被使用 2. 删除角色权限关联表数据
        roleService.removeById(roleId);
    }

    public PageVO<RoleListVO> findPage(PageQuery<?> query) {
        Page<Role> page = query.toMpPage();
        roleService.page(page);
        return PageVO.of(page, RoleListVO.class);
    }

    public RoleDetailVO getRoleById(Long roleId) {
        Role role = roleService.getById(roleId);
        return MsRoleMapper.INSTANCE.role2RoleDetailVO(role);
    }
}
