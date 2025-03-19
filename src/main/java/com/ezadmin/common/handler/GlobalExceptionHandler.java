package com.ezadmin.common.handler;

import com.ezadmin.common.exception.EzAdminException;
import com.ezadmin.common.result.R;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * 全局异常处理
 * </p>
 *
 * @author shenyang
 * @since 2024-08-05 18:09:15
 */
@Slf4j
@Hidden  // swagger忽略 解决 springboot3.4.x 与 openApi 版本兼容问题
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public R<String> handlerException(Exception e) {
        log.error("ezadmin service has error [{}]", e.getMessage(), e);
        return R.error(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public <T> R<T> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("⾮法参数异常，异常原因：{}", e.getMessage(), e);
        return R.error(e.getMessage());
    }

    /**
     * 系统业务异常处理
     *
     * @param e exception
     * @return R
     */
    @ExceptionHandler(value = EzAdminException.class)
    public R<String> handlerThinkfonException(EzAdminException e) {
        log.error("ezadmin service has error [{}]", e.getMessage(), e);
        return R.error(e.getCode(), e.getMessage());
    }


}
