package com.ezadmin.common.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 统一返回对象
 * </p>
 *
 * @author 曹申阳
 * @since 2024-10-12 14:05:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 返回业务请求状态码
     */
    private Integer code;
    /**
     * 返回消息描述
     */
    private String message;
    /**
     * 请求结果是否成功
     */
    private boolean success;
    /**
     * 返回对象数据
     */
    private T data;

    // 预定的状态码
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_ERROR = 500;

    public static <T> R<T> ok() {
        return new R<>(CODE_SUCCESS, "ok", true, null);
    }

    public static <T> R<T> ok(String message, T data) {
        return new R<>(CODE_SUCCESS, message, true, data);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(CODE_SUCCESS, "ok", true, data);
    }


    public static <T> R<T> error() {
        return new R<>(CODE_ERROR, "error", false, null);
    }

    public static <T> R<T> error(String message) {
        return new R<>(CODE_ERROR, message, false, null);

    }

    public static <T> R<T> error(Integer code, String message) {
        return new R<>(code, message, false, null);
    }

}
