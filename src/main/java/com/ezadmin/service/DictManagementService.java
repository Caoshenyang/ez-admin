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

    public PageVO<DictTypeListVO> findDictTypePage(PageQuery<?> dictTypeQuery) {
        Page<DictType> mpPage = dictTypeQuery.toMpPage();
        Page<DictType> page = dictTypeService.page(mpPage);
        return PageVO.of(page, DictTypeListVO.class);
    }

    public void createDictType(DictTypeCreateDTO dictTypeCreateDTO) {
        DictType dictType = MsDictMapper.INSTANCE.dictTypeCreateDTO2DictType(dictTypeCreateDTO);
        dictTypeService.save(dictType);
    }

    public void updateDictType(DictTypeUpdateDTO dictTypeUpdateDTO) {
        DictType dictType = MsDictMapper.INSTANCE.dictTypeUpdateDTO2DictType(dictTypeUpdateDTO);
        dictTypeService.updateById(dictType);
    }

    public void deleteDictType(Long dictId) {
        dictTypeService.removeById(dictId);
    }

    public DictTypeDetailVO getDictTypeById(Long dictId) {
        return MsDictMapper.INSTANCE.dictType2DictTypeDetailVO(dictTypeService.getById(dictId));
    }

    public List<DictDataListVO> getDictDataByDictId(Long dictId) {
        LambdaQueryWrapper<DictData> queryWrapper = new LambdaQueryWrapper<DictData>().eq(DictData::getDictId, dictId)
                .orderByAsc(DictData::getDictSort);
        return MsDictMapper.INSTANCE.dictData2DictDataListVOs(dictDataService.list(queryWrapper));
    }

    public void createDictData(DictDataCreateDTO dictDataCreateDTO) {
        DictData dictData = MsDictMapper.INSTANCE.dictDataCreateDTO2DictData(dictDataCreateDTO);
        dictDataService.save(dictData);
    }

    public void updateDictData(DictDataUpdateDTO dictDataUpdateDTO) {
        DictData dictData = MsDictMapper.INSTANCE.dictDataUpdateDTO2DictData(dictDataUpdateDTO);
        dictDataService.updateById(dictData);
    }

    public void deleteDictData(Long dictDataId) {
        dictDataService.removeById(dictDataId);
    }
}
