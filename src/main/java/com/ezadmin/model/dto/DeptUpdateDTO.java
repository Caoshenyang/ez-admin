package com.ezadmin.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 类名: DeptCreateDTO
 * 功能描述: 部门更新
 *
 * @author shenyang
 * @since 2025/3/19 17:42
 */
@Data
public class DeptUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @Schema(description = "部门ID")
    private Long deptId;

    /**
     * 部门名称
     */
    @Schema(description = "部门名称")
    private String deptName;

    /**
     * 部门排序
     */
    @Schema(description = "部门排序")
    private Integer deptSort;

    /**
     * 部门状态 【0 停用 1 正常】
     */
    @Schema(description = "部门状态 【0 停用 1 正常】")
    private Integer status;

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


}
