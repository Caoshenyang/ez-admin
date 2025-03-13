package com.ezadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.ezadmin.modules.**.mapper")
@SpringBootApplication
public class EzAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(EzAdminApplication.class, args);
    }

}
