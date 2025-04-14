package com.ezadmin.model.dto;

import com.ezadmin.common.annotation.SnowflakeId;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 类名: RoleMenuRelationDTO
 * 功能描述: 角色菜单关联对象
 *
 * @author shenyang
 * @since 2025/4/14 14:34
 */
@Data
public class RoleMenuRelationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @SnowflakeId
    private Long roleId;

    private List<String> menuIds;
}
