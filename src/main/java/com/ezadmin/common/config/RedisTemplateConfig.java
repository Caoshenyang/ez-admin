package com.ezadmin.common.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * <p>
 * RedisTemplateConfig
 * </p>
 *
 * @author 曹申阳
 * @since 2024-10-24 10:17:34
 */
@Configuration
public class RedisTemplateConfig {
    @Bean
    @Primary
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());

        // 使用GenericJackson2JsonRedisSerializer来序列化和反序列化redis的value值
        GenericJackson2JsonRedisSerializer serializer = getGenericJackson2JsonRedisSerializer();
        template.setValueSerializer(serializer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }

    private static GenericJackson2JsonRedisSerializer getGenericJackson2JsonRedisSerializer() {
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        serializer.configure(objectMapper -> {
            // 处理时间格式
            objectMapper.registerModule(new JavaTimeModule());
            // 关闭WRITE_DATES_AS_TIMESTAMPS特性，以确保日期/时间序列化为ISO-8601字符串
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            // 配置不序列化为null的值
            objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        });
        return serializer;
    }

}
