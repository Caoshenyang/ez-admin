package com.ezadmin.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 类名: DictDataDetailVO
 * 功能描述: 字典详情
 *
 * @author shenyang
 * @since 2025/4/18 14:17
 */
@Data
public class DictDataDetailVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "字典详情主键ID")
    private Long dictDataId;

    @Schema(description = "字典标签")
    private String dictLabel;

    @Schema(description = "字典键值")
    private String dictValue;

    @Schema(description = "字典排序")
    private Integer dictSort;

    @Schema(description = "表格回显样式")
    private String listClass;

    @Schema(description = "是否默认【0 否 1 是】")
    private Integer isDefault;

    @Schema(description = "状态【0 停用 1 正常】")
    private Integer status;

    @Schema(description = "描述信息")
    private String description;
}
