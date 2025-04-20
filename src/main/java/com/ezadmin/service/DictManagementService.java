package com.ezadmin.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ezadmin.common.result.page.PageQuery;
import com.ezadmin.common.result.page.PageVO;
import com.ezadmin.model.dto.DictDataCreateDTO;
import com.ezadmin.model.dto.DictDataUpdateDTO;
import com.ezadmin.model.dto.DictTypeCreateDTO;
import com.ezadmin.model.dto.DictTypeUpdateDTO;
import com.ezadmin.model.mpstruct.MsDictMapper;
import com.ezadmin.model.vo.DictDataDetailVO;
import com.ezadmin.model.vo.DictDataListVO;
import com.ezadmin.model.vo.DictTypeDetailVO;
import com.ezadmin.model.vo.DictTypeListVO;
import com.ezadmin.modules.system.entity.DictData;
import com.ezadmin.modules.system.entity.DictType;
import com.ezadmin.modules.system.service.IDictDataService;
import com.ezadmin.modules.system.service.IDictTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名: DictManagementService
 * 功能描述: 字典管理
 *
 * @author shenyang
 * @since 2025/3/19 15:42
 */
@Service
@RequiredArgsConstructor
public class DictManagementService {

    private final IDictTypeService dictTypeService;
    private final IDictDataService dictDataService;

    /**
     * 查询字典类型分页
     * @param dictTypeQuery 查询条件
     * @return PageVO<DictTypeListVO>
     */
    public PageVO<DictTypeListVO> findDictTypePage(PageQuery<?> dictTypeQuery) {
        Page<DictType> mpPage = dictTypeQuery.toMpPage();
        Page<DictType> page = dictTypeService.page(mpPage);
        return PageVO.of(page, DictTypeListVO.class);
    }

    /**
     * 创建字典类型
     * @param dictTypeCreateDTO 字典类型创建DTO
     */
    public void createDictType(DictTypeCreateDTO dictTypeCreateDTO) {
        DictType dictType = MsDictMapper.INSTANCE.dictTypeCreateDTO2DictType(dictTypeCreateDTO);
        dictTypeService.save(dictType);
    }

    /**
     * 更新字典类型
     * @param dictTypeUpdateDTO 字典类型更新DTO
     */
    public void updateDictType(DictTypeUpdateDTO dictTypeUpdateDTO) {
        DictType dictType = MsDictMapper.INSTANCE.dictTypeUpdateDTO2DictType(dictTypeUpdateDTO);
        dictTypeService.updateById(dictType);
    }

    /**
     * 删除字典类型
     * @param dictId 字典类型ID
     */
    public void deleteDictType(Long dictId) {
        dictTypeService.removeById(dictId);
    }

    /**
     * 获取字典类型详情
     * @param dictId 字典类型ID
     * @return 字典类型详情VO
     */
    public DictTypeDetailVO getDictTypeById(Long dictId) {
        return MsDictMapper.INSTANCE.dictType2DictTypeDetailVO(dictTypeService.getById(dictId));
    }

    /**
     * 根据字典类型ID获取字典数据
     * @param dictId 字典类型ID
     * @return List<DictDataListVO>
     */
    public List<DictDataListVO> getDictDataByDictId(Long dictId) {
        LambdaQueryWrapper<DictData> queryWrapper = new LambdaQueryWrapper<DictData>().eq(DictData::getDictId, dictId)
                .orderByAsc(DictData::getDictSort);
        return MsDictMapper.INSTANCE.dictData2DictDataListVOs(dictDataService.list(queryWrapper));
    }

    /**
     * 创建字典数据
     * @param dictDataCreateDTO  字典数据创建DTO
     */
    public void createDictData(DictDataCreateDTO dictDataCreateDTO) {
        DictData dictData = MsDictMapper.INSTANCE.dictDataCreateDTO2DictData(dictDataCreateDTO);
        dictDataService.save(dictData);
    }

    /**
     * 更新字典数据
     * @param dictDataUpdateDTO 字典数据更新DTO
     */
    public void updateDictData(DictDataUpdateDTO dictDataUpdateDTO) {
        DictData dictData = MsDictMapper.INSTANCE.dictDataUpdateDTO2DictData(dictDataUpdateDTO);
        dictDataService.updateById(dictData);
    }

    /**
     * 删除字典数据
     * @param dictDataId 字典数据ID
     */
    public void deleteDictData(Long dictDataId) {
        dictDataService.removeById(dictDataId);
    }

    /**
     * 根据字典数据ID获取字典数据详情
     * @param dictDataId 字典数据ID
     * @return DictDataDetailVO
     */
    public DictDataDetailVO getDictDataById(Long dictDataId) {
        return MsDictMapper.INSTANCE.dictData2DictDataDetailVO(dictDataService.getById(dictDataId));
    }
}
