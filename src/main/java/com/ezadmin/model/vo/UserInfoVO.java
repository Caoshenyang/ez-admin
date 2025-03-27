package com.ezadmin.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Schema(description = "主键ID")
    private Long userId;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "权限信息")
    private List<String> permissions;

    @Schema(description = "路由信息")
    private List<MenuTreeVO> menus;
}
