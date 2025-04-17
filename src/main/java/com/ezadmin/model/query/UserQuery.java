package com.ezadmin.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 类名: UserQuery 用户查询
 * 功能描述:
 *
 * @author shenyang
 * @since 2025/3/19 16:37
 */
@Data
public class UserQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "部门")
    private Long deptId;
}
