package com.ezadmin.model.vo;

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

    @Schema(description = "主键ID")
    private Long userId;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

}
