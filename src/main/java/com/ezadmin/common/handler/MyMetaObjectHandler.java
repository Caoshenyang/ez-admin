package com.ezadmin.common.handler;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * <p>
 *  MyBatis-Plus自动填充
 * </p>
 *
 * @author shenyang
 * @since 2024-10-12 15:47:48
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        String username = getCurrentUsername();
        this.strictInsertFill(metaObject, "createBy", String.class, username);
        this.strictUpdateFill(metaObject, "updateBy", String.class, username);
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        String username = getCurrentUsername();
        this.strictUpdateFill(metaObject, "updateBy", String.class, username);
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }

    /**
     * 获取当前登录用户名
     *
     * @return username
     */
    private static String getCurrentUsername() {
        String username = "anonymous";
        if (StpUtil.getExtra("username") != null){
            username = StpUtil.getExtra("username").toString();
        }
        return username;
    }
}
