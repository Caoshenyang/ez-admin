package com.ezadmin.model.vo;

import com.ezadmin.common.result.tree.TreeNode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 类名: DeptTreeVO
 * 功能描述: 部门树列表
 *
 * @author shenyang
 * @since 2025/3/20 14:52
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTreeVO extends TreeNode implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "部门ID")
    private Long deptId;

    @Schema(description = "部门名称")
    private String deptName;

    @Schema(description = "祖级列表")
    private String ancestors;

    @Schema(description = "父级菜单ID")
    private Long parentId;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @JsonIgnore
    @Override
    public Long getNodeId() {
        return deptId;
    }
}
