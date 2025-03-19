package com.ezadmin.common.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  AppConfigProperties
 * </p>
 *
 * @author shenyang
 * @since 2024-11-01 15:41:24
 */

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "app")
public class AppConfigProperties {

    private Info info;

    @Data
    public static class Info {
        private String name;
        private String version;
        private String author;
    }


}
