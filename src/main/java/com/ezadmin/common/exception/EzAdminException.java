package com.ezadmin.common.exception;


/**
 * <p>
 * ezadmin 系统异常
 * </p>
 *
 * @author 曹申阳
 * @since 2024-08-05 18:07:37
 */
public class EzAdminException extends RuntimeException {
    /**
     * 错误码
     */
    private final ExceptionEnum exceptionEnum;

    public EzAdminException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }


    public Integer getCode() {
        return exceptionEnum.getCode();
    }

    @Override
    public String getMessage() {
        return exceptionEnum.getMessage();
    }
}
