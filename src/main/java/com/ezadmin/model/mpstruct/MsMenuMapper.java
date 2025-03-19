package com.ezadmin.model.mpstruct;

import com.ezadmin.model.vo.MenuPermissionVO;
import com.ezadmin.model.vo.RouterVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 类名: MsMenuMapper
 * 功能描述: 菜单相关实体转化
 *
 * @author shenyang
 * @since 2025/3/19 11:27
 */
@Mapper
public interface MsMenuMapper {

    MsMenuMapper INSTANCE = Mappers.getMapper(MsMenuMapper.class);

    List<RouterVO> MenuPermissionVO2RouterVOs(List<MenuPermissionVO> menuByRoleLabels);
}
