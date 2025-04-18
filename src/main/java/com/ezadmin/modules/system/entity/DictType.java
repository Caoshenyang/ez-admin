package com.ezadmin.modules.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author shenyang
 * @since 2025-04-18
 */
@Getter
@Setter
@ToString
@TableName("ez_admin_dict_type")
@Schema(name = "DictType", description = "字典类型表")
public class DictType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字典主键
     */
    @Schema(description = "字典主键")
    @TableId(value = "dict_id", type = IdType.ASSIGN_ID)
    private Long dictId;

    /**
     * 字典名称
     */
    @Schema(description = "字典名称")
    private String dictName;

    /**
     * 字典类型
     */
    @Schema(description = "字典类型")
    private String dictType;

    /**
     * 状态【0 停用 1 正常】
     */
    @Schema(description = "状态【0 停用 1 正常】")
    private Integer status;

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    @Schema(description = "更新者")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 描述信息
     */
    @Schema(description = "描述信息")
    private String description;
}
