package com.ezadmin.common.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * 类名: SaTokenMvcConfig
 * 功能描述: mvc 相关配置类
 *
 * @author shenyang
 * @since 2025/3/15 14:00
 */
@Slf4j
@Configuration
@Import(HttpMessageConvertersAutoConfiguration.class)
@ConditionalOnClass(WebMvcConfigurer.class)  // 判断是否引入了 WebMVC
public class SaTokenMvcConfig implements WebMvcConfigurer {

    // 动态获取哪些 path 可以忽略鉴权
    public static List<String> excludePaths() {
        // 此处仅为示例，实际项目你可以写任意代码来查询这些path
        return Arrays.asList(
                "/doc.html",
                "/swagger-resources/**",
                "/v3/api-docs/**",
                "/webjars/**",
                "/favicon.ico",
                "/auth/**");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，打开注解式鉴权功能
        registry.addInterceptor(new SaInterceptor(handle -> SaRouter
                .match("/**")
                .notMatch(excludePaths())
                .check(r -> StpUtil.checkLogin()))).addPathPatterns("/**");
    }
}
