package com.ezadmin.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 类名: UserCreateDTO
 * 功能描述: 用户新建
 *
 * @author shenyang
 * @since 2025/3/19 14:01
 */
@Data
public class UserCreateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @Schema(description = "部门ID")
    private Long deptId;

    /**
     * 用户账号
     */
    @Schema(description = "用户账号")
    private String username;

    /**
     * 密码
     */
    @Schema(description = "密码")
    private String password;

    /**
     * 用户昵称
     */
    @Schema(description = "用户昵称")
    private String nickname;

    /**
     * 用户邮箱
     */
    @Schema(description = "用户邮箱")
    private String email;

    /**
     * 用户手机号码
     */
    @Schema(description = "用户手机号码")
    private String phoneNumber;

    /**
     * 性别【0 保密 1 男 2 女】
     */
    @Schema(description = "性别【0 保密 1 男 2 女】")
    private Integer gender;

    /**
     * 用户头像
     */
    @Schema(description = "用户头像")
    private String avatar;


}
