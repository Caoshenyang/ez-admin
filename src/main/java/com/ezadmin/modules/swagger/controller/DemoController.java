package com.ezadmin.modules.swagger.controller;

import com.ezadmin.model.vo.UserVO;
import com.ezadmin.modules.system.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("body")
@Tag(name = "body参数")
public class DemoController {

    @Operation(summary = "普通body请求")
    @PostMapping("/body")
    public ResponseEntity<UserVO> body(@RequestBody UserVO user){
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "普通body请求+Param+Header+Path")
    @Parameters({
            @Parameter(name = "id",description = "文件id",in = ParameterIn.PATH),
            @Parameter(name = "token",description = "请求token",required = true,in = ParameterIn.HEADER),
            @Parameter(name = "name",description = "文件名称",required = true,in=ParameterIn.QUERY)
    })
    @PostMapping("/bodyParamHeaderPath/{id}")
    public ResponseEntity<String> bodyParamHeaderPath(@PathVariable("id") String id, @RequestHeader("token") String token, @RequestParam("name")String name, @RequestBody User user){
        String s = user.toString() + ",receiveName:" + name + ",token:" + token + ",pathID:" + id;
        return ResponseEntity.ok(s);
    }
}
