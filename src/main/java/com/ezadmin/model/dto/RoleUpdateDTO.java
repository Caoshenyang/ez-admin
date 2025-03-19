package com.ezadmin.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 类名: RoleCreateDTO
 * 功能描述: 角色创建对象
 *
 * @author shenyang
 * @since 2025/3/19 17:08
 */
@Data
public class RoleUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @Schema(description = "角色ID")
    @TableId(value = "role_id", type = IdType.ASSIGN_ID)
    private Long roleId;

    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    private String roleName;

    /**
     * 角色权限字符标识
     */
    @Schema(description = "角色权限字符标识")
    private String roleLabel;

    /**
     * 排序
     */
    @Schema(description = "排序")
    private Integer roleSort;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

}
