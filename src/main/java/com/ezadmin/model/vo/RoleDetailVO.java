package com.ezadmin.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 类名: RoleDetailVO
 * 功能描述: 用角色信息
 *
 * @author shenyang
 * @since 2025/3/17 13:37
 */
@Data
public class RoleDetailVO implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Schema(description = "主键ID")
    private Long roleId;

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色标识")
    private String roleLabel;

    @Schema(description = "排序")
    private Integer roleSort;

    @Schema(description = "数据权限【1 本人 2 本部门 3 本部门及以下  4 自定义 5 全部】")
    private Long dataScope;

    @Schema(description = "数据权限值")
    private String dataScopeValue;

    @Schema(description = "描述")
    private String description;
}
