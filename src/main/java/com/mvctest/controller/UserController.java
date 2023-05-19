package com.mvctest.controller;

import com.mvctest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/Users")
public class UserController {
    @Autowired
    private UserService userService;
@RequestMapping(method = RequestMethod.GET)
    public String getAllUsers(){
    System.out.println("查看所有用户");
    return  "查看所有用户";

}
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)

    public String getUserById(@PathVariable int id){
        return  "查看特定用户"+id;
        //return "/pages/test222.html";

    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)

    public String updateUserById(@PathVariable int id){
        return  "更新特定用户"+id;

    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)

    public String deleteUserById(@PathVariable int id){
        return  "删除特定用户"+id;

    }
    @RequestMapping(method = RequestMethod.POST)

    public String createUser(@RequestBody Map<String, Object> json) throws NoSuchAlgorithmException {
        String username = (String) json.get("username");
        String password = (String) json.get("password");
        System.out.println(username+"    "+password);
        boolean success = userService.register(username,password);
        if(success){
            return  "注册成功";
        }
        return  "注册失败";
    }

}
