package com.ezadmin.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 类名: TokenInfoVO
 * 功能描述: TokenInfoVO 返回用户 token, 不直接返回字符串，使用对象的好处在于便于扩展
 *
 * @author shenyang
 * @since 2025/3/17 10:16
 */
@Data
public class TokenInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "tokenName")
    private String tokenName;

    @Schema(description = "tokenValue")
    private String tokenValue;

}
