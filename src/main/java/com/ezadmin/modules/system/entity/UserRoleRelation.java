package com.ezadmin.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
@Getter
@Setter
@ToString
@TableName("ez_admin_user_role_relation")
@Schema(name = "UserRoleRelation", description = "用户角色关联表")
public class UserRoleRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Long userId;

    /**
     * 角色ID
     */
    @Schema(description = "角色ID")
    private Long roleId;
}
