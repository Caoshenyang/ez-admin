package com.ezadmin.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 类名: UserInfoVO
 * 功能描述: 用户信息
 *
 * @author shenyang
 * @since 2025/3/17 13:33
 */
@Data
public class UserInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long userId;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "用户角色")
    private List<RoleDetailVO> roles;

//    @Schema(description = "用户菜单")
//    private List<MenuPermissionVO> menus;
}
