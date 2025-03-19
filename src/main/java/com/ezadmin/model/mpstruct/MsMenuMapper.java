package com.ezadmin.model.mpstruct;

import com.ezadmin.model.vo.MenuPermissionVO;
import com.ezadmin.model.vo.RouterTreeVO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 类名: MsMenuMapper
 * 功能描述: 菜单相关实体转化
 *
 * @author shenyang
 * @since 2025/3/19 11:27
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MsMenuMapper {

    MsMenuMapper INSTANCE = Mappers.getMapper(MsMenuMapper.class);

    List<RouterTreeVO> MenuPermissionVO2RouterTreeVOs(List<MenuPermissionVO> menuByRoleLabels);
}
