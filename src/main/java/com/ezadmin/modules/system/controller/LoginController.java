package com.ezadmin.modules.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.ezadmin.model.vo.UserVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acc/")
public class LoginController {

    // 测试登录
    @PostMapping("login")
    public SaResult login() {
        StpUtil.login(10001);
        return SaResult.ok("登录成功");
    }

    // 查询登录状态
    @GetMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    // 测试注销
    @PostMapping("logout")
    public SaResult logout(@RequestBody UserVO user) {
        StpUtil.logout();
        return SaResult.ok();
    }
}
