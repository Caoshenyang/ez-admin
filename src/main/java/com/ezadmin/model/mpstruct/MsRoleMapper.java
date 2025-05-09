package com.ezadmin.model.mpstruct;

import com.ezadmin.model.dto.RoleCreateDTO;
import com.ezadmin.model.dto.RoleUpdateDTO;
import com.ezadmin.model.vo.RoleDetailVO;
import com.ezadmin.model.vo.RoleListVO;
import com.ezadmin.modules.system.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 类名: MsRoleMapper
 * 功能描述: 角色实体转化类
 *
 * @author shenyang
 * @since 2025/3/17 16:21
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MsRoleMapper {
    MsRoleMapper INSTANCE = Mappers.getMapper(MsRoleMapper.class);

    Role roleCreateDTO2Role(RoleCreateDTO roleCreateDTO);

    Role roleUpdateDTO2Role(RoleUpdateDTO roleUpdateDTO);

    RoleDetailVO role2RoleDetailVO(Role role);

    List<RoleListVO> role2RoleListVOs(List<Role> roleList);
}
