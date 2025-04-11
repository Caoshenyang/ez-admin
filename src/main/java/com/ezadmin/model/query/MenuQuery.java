package com.ezadmin.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 类名: MenuQuery
 * 功能描述: 菜单查询参数
 *
 * @author shenyang
 * @since 2025/4/11 10:21
 */
@Data
public class MenuQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "菜单状态")
    private Integer status;
}
