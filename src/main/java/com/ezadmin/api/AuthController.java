package com.ezadmin.api;

import com.ezadmin.common.result.R;
import com.ezadmin.service.AuthService;
import com.ezadmin.model.dto.LoginDTO;
import com.ezadmin.model.vo.TokenInfoVO;
import com.ezadmin.model.vo.UserInfoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "登录模块")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/")
public class AuthController {

private final AuthService authService;

    @Operation(summary = "初始化管理员账号")
    @PostMapping("/initialize")
    public R<String> initializeAdminAccount() {
        authService.initializeAdminAccount();
        return R.ok("初始化完成，管理员账号: admin, 密码: admin123456, 首次登录后请及时更改密码！");
    }


    @Operation(summary = "用户登录", description = "用户登录")
    @PostMapping("/login")
    public R<TokenInfoVO> login(@RequestBody LoginDTO loginDTO) {
        TokenInfoVO tokenInfoVO = authService.login(loginDTO);
        return R.ok(tokenInfoVO);
    }

    @Operation(summary = "获取用户信息", description = "获取用户信息")
    @GetMapping("/userInfo")
    public R<UserInfoVO> getUserInfo() {
        UserInfoVO userInfoVO = authService.getUserInfo();
        return R.ok(userInfoVO);
    }

    @Operation(summary = "登录注销", description = "登录注销")
    @PostMapping("logout")
    public R<String> logout() {
        authService.logout();
        return R.ok();
    }

}
