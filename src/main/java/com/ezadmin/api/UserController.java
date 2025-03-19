package com.ezadmin.api;

import com.ezadmin.common.result.R;
import com.ezadmin.model.dto.UserCreateDTO;
import com.ezadmin.modules.system.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
@Tag(name = "用户管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/user")
public class UserController {

    private final IUserService userService;

    @Operation(summary = "新增用户")
    @PostMapping("/save")
    public R<String> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        userService.createUser(userCreateDTO);
        return R.ok();
    }

    @Operation(summary = "修改用户")
    @PostMapping("/update")
    public R<String> updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        userService.updateUser(userUpdateDTO);
        return R.ok();
    }

    @Operation(summary = "删除用户")
    @DeleteMapping("/delete/{userId}")
    public R<String> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return R.ok();
    }

    @Operation(summary = "分页查询")
    @PostMapping("/page")
    public R<PageVO<UserListVO>> findPage(@RequestBody PageQuery<UserQuery> userQuery) {
        PageVO<UserListVO> page = userService.findPage(userQuery);
        return R.ok(page);
    }

    @Operation(summary = "查询用户权限")
    @GetMapping("/findPermissions/{userId}")
    public R<String> findPermissions(@PathVariable("userId") Long userId) {
        return R.ok();
    }

    @Operation(summary = "查询用户角色")
    @GetMapping("/findRoles/{userId}")
    public R<String> findRoles(@PathVariable("userId") Long userId) {
        return R.ok();
    }


}
