package com.ezadmin.model.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ezadmin.common.annotation.SnowflakeId;
import com.ezadmin.common.result.tree.TreeNode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 类名: MenuTreeVO
 * 功能描述: 菜单树
 *
 * @author shenyang
 * @since 2025/3/21 9:42
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuTreeVO extends TreeNode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @SnowflakeId
    @Schema(description = "菜单ID")
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
     * 父级菜单ID
     */
    @SnowflakeId
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

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "是否显示【0 否 1 是】")
    private Integer visible;

    @Schema(description = "触发事件名称【当为类型为按钮时】")
    private String buttonEvent;

    @Schema(description = "按钮样式【'primary' | 'success' | 'warning' | 'danger' | 'info'】")
    private String buttonStyle;

    @JsonIgnore
    @Override
    public Long getNodeId() {
        return menuId;
    }
}
