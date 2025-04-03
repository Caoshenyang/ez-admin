package com.ezadmin.common.serializer;

import com.ezadmin.common.annotation.SnowflakeId;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;

/**
 * 类名: SnowflakeIdArgumentResolver
 * 功能描述: 自定义雪花ID参数解析器
 *
 * @author shenyang
 * @since 2025/4/3 15:30
 */
public class SnowflakeIdArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 判断参数类型是否为Long类型，并且是否标注了@SnowflakeId注解
        return (parameter.hasParameterAnnotation(SnowflakeId.class) &&
                parameter.getParameterType() == Long.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        // 获取参数名
        String paramName = parameter.getParameterName();
        if (paramName == null) {
            return null;
        }
        // 尝试从请求参数获取
        String value = webRequest.getParameter(paramName);

        // 如果请求参数没有，尝试从路径变量获取
        if (value == null) {
            // 获取路径变量Map
            Object pathVarsObj = webRequest.getAttribute(
                    HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE,
                    RequestAttributes.SCOPE_REQUEST
            );
            // 从路径变量中获取值
            if (pathVarsObj instanceof Map<?, ?> rawMap) {
                Object valueObj = rawMap.get(paramName);
                if (valueObj instanceof String) {
                    value = (String) valueObj;
                }
            }
        }
        // 执行简单转换
        try {
            return value != null ? Long.valueOf(value) : null;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("参数" + paramName + "解析失败，请检查参数类型");
        }
    }
}
