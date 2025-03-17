package com.ezadmin.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * MenuPermissionVO
 * </p>
 *
 * @author 曹申阳
 * @since 2024-10-24 14:43:21
 */
@Data
public class MenuPermissionVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "角色ID")
    private Long roleId;

    @Schema(description = "主键ID")
    private Long menuId;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "菜单标识")
    private String menuLabel;

    @Schema(description = "菜单图标")
    private String menuIcon;

    @Schema(description = "菜单路径")
    private String menuPath;

    @Schema(description = "组件名称")
    private String component;

    @Schema(description = "菜单权限")
    private String menuPerm;

    @Schema(description = "父级菜单ID")
    private Long parentId;

    @Schema(description = "菜单类型【1 目录 2 菜单 3 按钮】")
    private Integer menuType;

    @Schema(description = "排序字段")
    private Integer menuSort;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "创建者")
    private String createBy;

    @Schema(description = "更新者")
    private String updateBy;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

}
