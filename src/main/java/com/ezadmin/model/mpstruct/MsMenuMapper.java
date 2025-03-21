package com.ezadmin.model.mpstruct;

import com.ezadmin.model.dto.MenuCreateDTO;
import com.ezadmin.model.dto.MenuUpdateDTO;
import com.ezadmin.model.vo.MenuDetailVO;
import com.ezadmin.model.vo.MenuPermissionVO;
import com.ezadmin.model.vo.MenuTreeVO;
import com.ezadmin.model.vo.RouterTreeVO;
import com.ezadmin.modules.system.entity.Menu;
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

    List<RouterTreeVO> menuPermissionVO2RouterTreeVOs(List<MenuPermissionVO> menuByRoleLabels);

    Menu menuCreateDTO2Menu(MenuCreateDTO menuCreateDTO);

    Menu menuUpdateDTO2Menu(MenuUpdateDTO menuUpdateDTO);

    List<MenuTreeVO> menu2MenuTreeVOs(List<Menu> menus);

    MenuDetailVO menu2MenuDetailVO(Menu menu);
}
