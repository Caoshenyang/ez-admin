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
 * 字典详情表
 * </p>
 *
 * @author shenyang
 * @since 2025-04-18
 */
@Getter
@Setter
@ToString
@TableName("ez_admin_dict_data")
@Schema(name = "DictData", description = "字典详情表")
public class DictData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字典详情主键ID
     */
    @Schema(description = "字典详情主键ID")
    @TableId(value = "dict_data_id", type = IdType.ASSIGN_ID)
    private Long dictDataId;

    /**
     * 字典类型ID
     */
    @Schema(description = "字典类型ID")
    private Long dictId;

    /**
     * 字典标签
     */
    @Schema(description = "字典标签")
    private String dictLabel;

    /**
     * 字典键值
     */
    @Schema(description = "字典键值")
    private String dictValue;

    /**
     * 字典排序
     */
    @Schema(description = "字典排序")
    private Integer dictSort;

    /**
     * 表格回显样式
     */
    @Schema(description = "表格回显样式")
    private String listClass;

    /**
     * 是否默认【0 否 1 是】
     */
    @Schema(description = "是否默认【0 否 1 是】")
    private Integer isDefault;

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
