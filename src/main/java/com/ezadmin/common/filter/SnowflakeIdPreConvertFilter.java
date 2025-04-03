package com.ezadmin.common.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.io.IOException;

/**
 * 类名: SnowflakeIdPreConvertFilter
 * 功能描述:
 *
 * @author shenyang
 * @since 2025/4/3 16:09
 */
@Order(Ordered.HIGHEST_PRECEDENCE)  // 比 SaPathCheckFilterForJakartaServlet 更高优先级
public class SnowflakeIdPreConvertFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        // 1. 转换路径变量（如 /api/123456）
        String pathInfo = httpRequest.getRequestURI();
        String[] pathParts = pathInfo.split("/");
        if (pathParts.length > 2) {
            String potentialId = pathParts[pathParts.length - 1];
            try {
                Long id = Long.parseLong(potentialId);
                httpRequest.setAttribute("PRE_CONVERTED_ID", id);  // 存入请求属性
            } catch (NumberFormatException ignored) {}
        }

        // 2. 转换查询参数（如 /api?id=123456）
        String paramId = httpRequest.getParameter("id");
        if (paramId != null) {
            try {
                Long id = Long.parseLong(paramId);
                httpRequest.setAttribute("PRE_CONVERTED_PARAM_ID", id);
            } catch (NumberFormatException ignored) {}
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
