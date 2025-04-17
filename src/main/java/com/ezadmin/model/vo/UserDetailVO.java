package com.ezadmin.model.vo;

import com.ezadmin.common.annotation.SnowflakeId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 类名: UserDetailVO
 * 功能描述: 用户详情
 *
 * @author shenyang
 * @since 2025/4/17 11:23
 */
@Data
public class UserDetailVO implements Serializable {
    private final static long serialVersionUID = 1L;

    @SnowflakeId
    @Schema(description = "用户ID")
    private Long userId;

    @SnowflakeId
    @Schema(description = "部门ID")
    private Long deptId;

    @Schema(description = "角色ID")
    private List<String> roleIds;

    @Schema(description = "用户昵称")
    private String nickname;

    @Schema(description = "用户邮箱")
    private String email;

    @Schema(description = "用户手机号码")
    private String phoneNumber;

    @Schema(description = "性别【0 未知 1 男 2 女 3 其它】")
    private Integer gender;

    @Schema(description = "用户头像")
    private String avatar;

    @Schema(description = "状态")
    private Integer status;

}
