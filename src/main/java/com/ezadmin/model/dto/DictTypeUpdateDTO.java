package com.ezadmin.model.dto;

import com.ezadmin.common.annotation.SnowflakeId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 类名: DictTypeUpdateDTO
 * 功能描述: 字典类型编辑
 *
 * @author shenyang
 * @since 2025/4/18 13:56
 */
@Data
public class DictTypeUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @SnowflakeId
    @Schema(description = "字典主键")
    private Long dictId;

    @Schema(description = "字典名称")
    private String dictName;

    @Schema(description = "字典类型")
    private String dictType;

    @Schema(description = "状态【0 停用 1 正常】")
    private Integer status;

    @Schema(description = "描述信息")
    private String description;
}
