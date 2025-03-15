package com.ezadmin.common.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 类名: LoginDTO
 * 功能描述: 登录请求对象
 *
 * @author shenyang
 * @since 2025/3/14 14:36
 */
@Data
public class LoginDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

}
