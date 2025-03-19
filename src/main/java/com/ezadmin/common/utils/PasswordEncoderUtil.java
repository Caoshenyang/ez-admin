package com.ezadmin.common.utils;

import cn.dev33.satoken.secure.BCrypt;

/**
 * <p>
 * 密码加解密 BCrypt
 * </p>
 *
 * @author shenyang
 * @since 2024-10-15 13:50:19
 */
public class PasswordEncoderUtil {


    // 工具类不允许实例化
    private PasswordEncoderUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 加密
     * @param password 密码明文
     * @return 加密后的密文
     */
    public static String encode(String password) {
        // BCrypt.gensalt() 默认复杂度 10
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * 校验密码
     * @param password 密码明文
     * @param encodePassword 加密后的密码
     * @return 是否匹配
     */
    public static boolean matches(String password, String encodePassword) {
        return BCrypt.checkpw(password, encodePassword);
    }

}
