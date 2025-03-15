package com.ezadmin.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 类名: ExceptionEnum
 * 功能描述: 异常枚举
 *
 * @author shenyang
 * @since 2025/3/14 16:23
 */
@Getter
@AllArgsConstructor
public enum ExceptionEnum {

    /**
     *  ezadmin 系统业务异常响应状态码  5xxx1 - 59999
     */
    USERNAME_OR_PASSWORD_NOT_EMPTY(50001,"用户名或密码不能为空"),
    USERNAME_NOT_EXISTS(50002,"用户名不存在"),
    USERNAME_OR_PASSWORD_ERROR(50003,"用户名或密码错误"),
    USERNAME_EXISTS(50002,"用户名已存在"),
    ADMIN_ACCOUNT_NOT_ALLOW_UPDATE(50003,"超级管理员不允许修改!"),
    LOGIN_FAIL(50004,"用户名或密码错误!"),
    NOT_PERMISSION(50005,"无权访问!"),
    HAVE_CHILDREN(50006,"有子菜单，不能删除")
    ;
    /**
     * 执行状态码
     */
    private final int code;
    /**
     * 执行状态描述
     */
    private final String message;
}
