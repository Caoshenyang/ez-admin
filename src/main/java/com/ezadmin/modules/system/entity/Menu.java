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
 * 菜单信息表
 * </p>
 *
 * @author shenyang
 * @since 2025-04-02
 */
@Getter
@Setter
@ToString
@TableName("ez_admin_menu")
@Schema(name = "Menu", description = "菜单信息表")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @Schema(description = "菜单ID")
    @TableId(value = "menu_id", type = IdType.ASSIGN_ID)
    private Long menuId;

    /**
     * 菜单名称
     */
    @Schema(description = "菜单名称")
    private String menuName;

    /**
     * 菜单图标
     */
    @Schema(description = "菜单图标")
    private String menuIcon;

    /**
     * 触发事件名称【当为类型为按钮时】
     */
    @Schema(description = "触发事件名称【当为类型为按钮时】")
    private String buttonEvent;

    /**
     * 按钮样式【'primary' | 'success' | 'warning' | 'danger' | 'info'】
     */
    @Schema(description = "按钮样式【'primary' | 'success' | 'warning' | 'danger' | 'info'】")
    private String buttonStyle;

    /**
     * 父级菜单ID
     */
    @Schema(description = "父级菜单ID")
    private Long parentId;

    /**
     * 菜单排序
     */
    @Schema(description = "菜单排序")
    private Integer menuSort;

    /**
     * 菜单类型【1 目录 2 菜单 3 按钮】
     */
    @Schema(description = "菜单类型【1 目录 2 菜单 3 按钮】")
    private Integer menuType;

    /**
     * 权限标识
     */
    @Schema(description = "权限标识")
    private String menuPerm;

    /**
     * 路由地址
     */
    @Schema(description = "路由地址")
    private String routePath;

    /**
     * 路由名称
     */
    @Schema(description = "路由名称")
    private String routeName;

    /**
     * 组件路径
     */
    @Schema(description = "组件路径")
    private String componentPath;

    /**
     * 菜单状态【0 停用 1 正常】
     */
    @Schema(description = "菜单状态【0 停用 1 正常】")
    private Integer status;


    /**
     * 是否显示【0 否 1 是】
     */
    @Schema(description = "是否显示【0 否 1 是】")
    private Integer visible;

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

    /**
     * 是否删除【0 正常 1 已删除】
     */
    @TableLogic
    @Schema(description = "是否删除【0 正常 1 已删除】")
    private Integer isDeleted;
}
