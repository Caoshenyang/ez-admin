package com.ezadmin.model.mpstruct;

import com.ezadmin.model.dto.*;
import com.ezadmin.model.vo.DictDataListVO;
import com.ezadmin.model.vo.DictTypeDetailVO;
import com.ezadmin.model.vo.RoleDetailVO;
import com.ezadmin.model.vo.RoleListVO;
import com.ezadmin.modules.system.entity.DictData;
import com.ezadmin.modules.system.entity.DictType;
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
public interface MsDictMapper {
    MsDictMapper INSTANCE = Mappers.getMapper(MsDictMapper.class);


    DictType dictTypeCreateDTO2DictType(DictTypeCreateDTO dictTypeCreateDTO);

    DictType dictTypeUpdateDTO2DictType(DictTypeUpdateDTO dictTypeUpdateDTO);

    DictTypeDetailVO dictType2DictTypeDetailVO(DictType dictType);

    List<DictDataListVO> dictData2DictDataListVOs(List<DictData> list);

    DictData dictDataCreateDTO2DictData(DictDataCreateDTO dictDataCreateDTO);

    DictData dictDataUpdateDTO2DictData(DictDataUpdateDTO dictDataUpdateDTO);
}
