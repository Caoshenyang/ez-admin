package com.ezadmin.modules.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.ezadmin.common.model.dto.LoginDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/")
public class LoginController {

    // 测试登录
    @PostMapping("/login")
    public SaResult login(@RequestBody LoginDTO loginDTO) {
        int a = 1/0;
        StpUtil.login(10001);
        return SaResult.ok("登录成功");
    }

}
