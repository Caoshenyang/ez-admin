package com.ezadmin.model.mpstruct;

import com.ezadmin.model.dto.DeptCreateDTO;
import com.ezadmin.model.dto.DeptUpdateDTO;
import com.ezadmin.model.vo.DeptDetailVO;
import com.ezadmin.model.vo.DeptTreeVO;
import com.ezadmin.modules.system.entity.Dept;
import com.ezadmin.modules.system.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 类名: MsDeptMapper
 * 功能描述: 部门对象转化类
 *
 * @author shenyang
 * @since 2025/3/19 17:48
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MsDeptMapper {
    MsDeptMapper INSTANCE = Mappers.getMapper(MsDeptMapper.class);

    Dept deptCreateDTO2Dept(DeptCreateDTO deptCreateDTO);

    Dept deptUpdateDTO2Dept(DeptUpdateDTO deptUpdateDTO);

    DeptDetailVO dept2DeptDetailDTO(Dept dept);

    List<DeptTreeVO> dept2DeptTreeVOs(List<Dept> list);
}
