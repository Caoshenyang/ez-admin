package com.ezadmin.common.serializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 类名: SnowflakeIdDeserializer
 * 功能描述: 雪花ID 反序列化器（String → Long）
 *
 * @author shenyang
 * @since 2025/4/3 14:01
 */
public class SnowflakeIdDeserializer extends JsonDeserializer<Long> {
    @Override
    public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        // 字符串转为Long类型
        return jsonParser.getText() == null ? null : Long.parseLong(jsonParser.getText());
    }
}
