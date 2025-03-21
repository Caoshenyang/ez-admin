package com.ezadmin.model.vo;

import com.ezadmin.common.result.tree.TreeNode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 类名: MenuTreeVO
 * 功能描述: 菜单树
 *
 * @author shenyang
 * @since 2025/3/21 9:42
 */
@Data
public class MenuDetailVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
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
     * 菜单标识
     */
    @Schema(description = "菜单标识")
    private String menuLabel;

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
     * 菜单状态【0 正常 1 停用】
     */
    @Schema(description = "菜单状态【0 正常 1 停用】")
    private Integer status;

}
