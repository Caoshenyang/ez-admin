package com.ezadmin.api;

import com.ezadmin.common.result.R;
import com.ezadmin.common.service.LoginServiceImpl;
import com.ezadmin.model.dto.LoginDTO;
import com.ezadmin.model.vo.TokenInfoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "登录模块")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/")
public class LoginController {

private final LoginServiceImpl loginService;

    @Operation(summary = "初始化管理员账号")
    @PostMapping("/initialize")
    public R<String> initializeAdminAccount() {
        loginService.initializeAdminAccount();
        return R.ok("初始化完成，管理员账号: admin, 密码: admin123456, 首次登录后请及时更改密码！");
    }


    @Operation(summary = "用户登录", description = "用户登录")
    @PostMapping("/login")
    public R<TokenInfoVO> login(@RequestBody LoginDTO loginDTO) {
        TokenInfoVO tokenInfoVO = loginService.login(loginDTO);
        return R.ok(tokenInfoVO);
    }

}
