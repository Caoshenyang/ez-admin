package com.ezadmin.common.annotation;

import com.ezadmin.common.serializer.SnowflakeIdDeserializer;
import com.ezadmin.common.serializer.SnowflakeIdSerializer;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.lang.annotation.*;

/**
 * 类名: 标记雪花ID字段或参数
 * 功能描述: 雪花ID自动序列化注解
 *  响应序列化时：Long → String
 *  JSON反序列化时：String → Long
 * @author shenyang
 * @since 2025/4/3 13:44
 */

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@JacksonAnnotationsInside  // 关键：声明为Jackson组合注解
@JsonSerialize(using = SnowflakeIdSerializer.class)  // 序列化处理器
@JsonDeserialize(using = SnowflakeIdDeserializer.class)  // 反序列化处理器
public @interface SnowflakeId {}