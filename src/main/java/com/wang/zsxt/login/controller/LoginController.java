package com.wang.zsxt.login.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wang.zsxt.login.service.LoginService;
import com.wang.zsxt.tool.JwtUtil;
import com.wang.zsxt.tool.Response;
import com.wang.zsxt.pojo.login.LoginPojo;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Response<Object> login(@RequestBody LoginPojo info) throws JsonProcessingException {
        return loginService.login(info);
    }

    @PostMapping("/current_user")
    public Response<HashMap<String, Object>> getCurrentUser() {
        return Response.success(loginService.getCurrentUser());
    }
}
