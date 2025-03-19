package com.ezadmin.model.vo;

import com.ezadmin.common.result.tree.TreeNode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 路由信息
 * </p>
 *
 * @author 曹申阳
 * @since 2024-11-19 13:40:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RouterVO extends TreeNode implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long menuId;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "菜单标识")
    private String menuLabel;

    @Schema(description = "权限字符集")
    private String menuPerm;

    @Schema(description = "父级菜单ID")
    private Long parentId;

    @Schema(description = "菜单类型【1 目录 2 菜单 3 按钮】")
    private Integer menuType;

    @Schema(description = "排序字段")
    private Integer menuSort;

    @Schema(description = "菜单图标")
    private String menuIcon;

    @Schema(description = "菜单路径")
    private String menuPath;

    @Schema(description = "组件名称")
    private String component;

    @Schema(description = "描述")
    private String description;

    @JsonIgnore
    @Override
    public Long getNodeId() {
        return menuId;
    }
}
