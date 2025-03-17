package com.ezadmin.model.vo;

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

    @Schema(description = "主键ID")
    private Long roleId;

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色标识")
    private String roleLabel;

    @Schema(description = "数据权限【1 本人 2 本部门  3 自定义 4 全部】")
    private Long dataScope;

    @Schema(description = "描述")
    private String remark;
}
