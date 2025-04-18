package com.ezadmin.api;

import com.ezadmin.common.result.R;
import com.ezadmin.common.result.page.PageQuery;
import com.ezadmin.common.result.page.PageVO;
import com.ezadmin.model.dto.DictDataCreateDTO;
import com.ezadmin.model.dto.DictDataUpdateDTO;
import com.ezadmin.model.dto.DictTypeCreateDTO;
import com.ezadmin.model.dto.DictTypeUpdateDTO;
import com.ezadmin.model.vo.DictDataListVO;
import com.ezadmin.model.vo.DictTypeDetailVO;
import com.ezadmin.model.vo.DictTypeListVO;
import com.ezadmin.service.DictManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 字典详情表 前端控制器
 * </p>
 *
 * @author shenyang
 * @since 2025-04-18
 */
@Tag(name = "字典管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/dict")
public class DictController {

    private final DictManagementService dictManagementService;

    @Operation(summary = "查询字典类型(分页)")
    @PostMapping("/type/page")
    public R<PageVO<DictTypeListVO>> findDictTypePage(@RequestBody PageQuery<?> dictTypeQuery) {
        PageVO<DictTypeListVO> page = dictManagementService.findDictTypePage(dictTypeQuery);
        return R.ok(page);
    }

    @Operation(summary = "新增字典类型")
    @PostMapping("/type/create")
    public R<String> createDictType(@RequestBody DictTypeCreateDTO dictTypeCreateDTO) {
        dictManagementService.createDictType(dictTypeCreateDTO);
        return R.ok();
    }

    @Operation(summary = "编辑字典类型")
    @PostMapping("/type/update")
    public R<String> updateDictType(@RequestBody DictTypeUpdateDTO dictTypeUpdateDTO) {
        dictManagementService.updateDictType(dictTypeUpdateDTO);
        return R.ok();
    }

    @Operation(summary = "删除字典类型")
    @PostMapping("/type/delete/{dictId}")
    public R<String> deleteDictType(@PathVariable Long dictId) {
        dictManagementService.deleteDictType(dictId);
        return R.ok();
    }

    @Operation(summary = "根据ID查询字典类型")
    @GetMapping("/type/{dictId}")
    public R<DictTypeDetailVO> getDictTypeById(@PathVariable Long dictId) {
        DictTypeDetailVO dictTypeById = dictManagementService.getDictTypeById(dictId);
        return R.ok(dictTypeById);
    }

    @Operation(summary = "根据字典类型查询字典数据")
    @GetMapping("/data/{dictId}")
    public R<List<DictDataListVO>> getDictDataByDictId(@PathVariable Long dictId) {
        List<DictDataListVO> dictDataListVOList = dictManagementService.getDictDataByDictId(dictId);
        return R.ok(dictDataListVOList);
    }

    @Operation(summary = "新增字典数据")
    @PostMapping("/data/create")
    public R<String> createDictData(@RequestBody DictDataCreateDTO dictDataCreateDTO) {
        dictManagementService.createDictData(dictDataCreateDTO);
        return R.ok();
    }

    @Operation(summary = "编辑字典数据")
    @PostMapping("/data/update")
    public R<String> updateDictData(@RequestBody DictDataUpdateDTO dictDataUpdateDTO) {
        dictManagementService.updateDictData(dictDataUpdateDTO);
        return R.ok();
    }

    @Operation(summary = "删除字典数据")
    @PostMapping("/data/delete/{dictDataId}")
    public R<String> deleteDictData(@PathVariable Long dictDataId) {
        dictManagementService.deleteDictData(dictDataId);
        return R.ok();
    }

}
