package com.ezadmin.model.vo;

import com.ezadmin.common.annotation.SnowflakeId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 类名: RoleListVO
 * 功能描述: 角色列表
 *
 * @author shenyang
 * @since 2025/3/19 17:32
 */
@Data
public class RoleListVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @SnowflakeId
    @Schema(description = "主键ID")
    private Long roleId;

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色标识")
    private String roleLabel;

    @Schema(description = "排序")
    private Integer roleSort;

    @Schema(description = "数据范围【1 仅本人数据权限 2 本部门数据权限 3 本部门及以下数据权限 4 自定义数据权限 5 全部数据权限】")
    private Integer dataScope;

    @Schema(description = "角色状态【0 停用 1 正常】")
    private Integer status;

}
