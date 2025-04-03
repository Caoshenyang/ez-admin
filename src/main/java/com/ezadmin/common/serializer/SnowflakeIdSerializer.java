package com.ezadmin.common.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 类名: SnowflakeIdSerializer
 * 功能描述: 序列化器（Long → String）
 *
 * @author shenyang
 * @since 2025/4/3 14:41
 */
public class SnowflakeIdSerializer extends JsonSerializer<Long> {
    @Override
    public void serialize(Long aLong, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        // Long类型转为字符串输出
        jsonGenerator.writeString(aLong.toString());
    }
}
