package com.ezadmin.modules.system.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 部门信息表
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
@Getter
@Setter
@ToString
@TableName("ez_admin_dept")
@Schema(name = "Dept", description = "部门信息表")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @Schema(description = "部门ID")
    @TableId(value = "dept_id", type = IdType.ASSIGN_ID)
    private Long deptId;

    /**
     * 部门名称
     */
    @Schema(description = "部门名称")
    private String deptName;

    /**
     * 祖级列表
     */
    @Schema(description = "祖级列表")
    private String ancestors;

    /**
     * 父级菜单ID
     */
    @Schema(description = "父级菜单ID")
    private Long parentId;

    /**
     * 描述
     */
    @Schema(description = "描述")
    private String description;

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 更新者
     */
    @Schema(description = "更新者")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 是否删除【0 正常 1 已删除】
     */
    @TableLogic
    @Schema(description = "是否删除【0 正常 1 已删除】")
    private Integer isDeleted;
}
