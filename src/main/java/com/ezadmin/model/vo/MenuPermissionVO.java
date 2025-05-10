package com.ezadmin.model.vo;

import com.ezadmin.common.annotation.SnowflakeId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * MenuPermissionVO
 * </p>
 *
 * @author shenyang
 * @since 2024-10-24 14:43:21
 */
@Data
public class MenuPermissionVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @SnowflakeId
    @Schema(description = "角色ID")
    private Long roleId;

    @SnowflakeId
    @Schema(description = "主键ID")
    private Long menuId;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "菜单图标")
    private String menuIcon;

    @Schema(description = "路由地址")
    private String routePath;

    @Schema(description = "路由名称")
    private String routeName;

    @Schema(description = "组件路径")
    private String componentPath;

    @Schema(description = "菜单权限")
    private String menuPerm;

    @SnowflakeId
    @Schema(description = "父级菜单ID")
    private Long parentId;

    @Schema(description = "菜单类型【1 目录 2 菜单 3 按钮】")
    private Integer menuType;

    @Schema(description = "排序字段")
    private Integer menuSort;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "是否显示【0 否 1 是】")
    private Integer visible;

    @Schema(description = "触发事件名称【当为类型为按钮时】")
    private String buttonEvent;

    @Schema(description = "按钮样式【'primary' | 'success' | 'warning' | 'danger' | 'info'】")
    private String buttonStyle;

}
