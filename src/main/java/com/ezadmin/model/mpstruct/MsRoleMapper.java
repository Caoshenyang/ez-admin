package com.ezadmin.model.mpstruct;

import com.ezadmin.model.vo.RoleDetailVO;
import com.ezadmin.modules.system.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 类名: MsRoleMapper
 * 功能描述: 角色实体转化类
 *
 * @author shenyang
 * @since 2025/3/17 16:21
 */
@Mapper
public interface MsRoleMapper {
    MsRoleMapper INSTANCE = Mappers.getMapper(MsRoleMapper.class);

    List<RoleDetailVO> role2RoleDetailVO(List<Role> roles);
}
