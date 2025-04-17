package com.ezadmin.model.vo;

import com.ezadmin.common.annotation.SnowflakeId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 类名: UserListVO
 * 功能描述: 用户列表VO对象
 *
 * @author shenyang
 * @since 2025/3/19 16:25
 */
@Data
public class UserListVO implements Serializable {
    private final static long serialVersionUID = 1L;

    @SnowflakeId
    @Schema(description = "主键ID")
    private Long userId;

    @SnowflakeId
    @Schema(description = "部门ID")
    private Long deptId;

    @Schema(description = "部门名称")
    private String deptName;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "用户邮箱")
    private String email;

    @Schema(description = "用户手机号码")
    private String phoneNumber;

    @Schema(description = "性别【0 未知 1 男 2 女 3 其它】")
    private Integer gender;

    @Schema(description = "用户状态【0 禁用 1 正常】")
    private Integer status;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
