package com.swagger2.swagger2.web;

import com.swagger2.swagger2.Dao.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "User 接口")
public class UserController {

    @ApiOperation(value = "查询用户",notes = "按照id")
    @ApiImplicitParam(paramType = "path",name ="id",value = "用户id",required = true)
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Integer id){
        return "/user/"+id;
    }

    @ApiResponses({
        @ApiResponse(code = 200,message = "删除成功"),
        @ApiResponse(code = 500,message = "删除失败")
    })
    
    @ApiOperation(value = "删除用户",notes = "依据id删除用户")
    @DeleteMapping("/user/{id}")
    public Integer deleteUserById(@PathVariable Integer id){
        return id;
    }

    @ApiOperation(value = "添加用户", notes = "传入用户名和地址")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name ="username", value = "用户名",required = true,defaultValue = "默认姓名"),
            @ApiImplicitParam(paramType = "query", name ="address", value = "用户地址",required = true,defaultValue = "默认地址")
    })

    @PostMapping("/user")
    public String addUser(@RequestParam String username, @RequestParam String address) {
        return username+":"+address;
    }

    @ApiOperation(value = "修改用户",notes ="传入新用户信息")
    @PutMapping("/user")
    public String update(@RequestBody User user) {
        return user.toString();
    }


}
