package com.ezadmin.modules.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.ezadmin.model.dto.LoginDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/")
public class LoginController {

    // 测试登录
    @PostMapping("/login")
    public SaResult login(@RequestBody LoginDTO loginDTO) {
        StpUtil.login(10001);
        return SaResult.ok("登录成功");
    }

}
