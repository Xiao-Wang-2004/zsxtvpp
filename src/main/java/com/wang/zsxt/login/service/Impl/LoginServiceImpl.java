package com.wang.zsxt.login.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wang.zsxt.login.dao.LoginDao;
import com.wang.zsxt.login.service.LoginService;
import com.wang.zsxt.pojo.login.LoginPojo;
import com.wang.zsxt.tool.AESUtil;
import com.wang.zsxt.tool.JwtUtil;
import com.wang.zsxt.tool.RequestUtil;
import com.wang.zsxt.tool.Response;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    Logger log = Logger.getLogger(LoginServiceImpl.class.getName());

    @Override
    public Response<Object> login(LoginPojo info) throws JsonProcessingException {
        String data = AESUtil.decrypt(info.getData());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(data);

        String username = jsonNode.get("username").asText();
        String password = jsonNode.get("password").asText();

        if (username.contains(" ")) {
            return Response.error("用户名不能包含空格");
        }
        if (password.contains(" ")) {
            return Response.error("密码不能包含空格");
        }

        HashMap<String,Object> param = new HashMap<>();
        param.put("username", username);
        param.put("password", password);

        if(loginDao.login(param) > 0){
            // 登录成功，生成token
            String userid = loginDao.getUserId(username);
            String token = JwtUtil.createToken(userid);
            return Response.success("登录成功", token);
        }else{
            return Response.error("账号或密码错误");
        }
    }

    @Override
    public HashMap<String, Object> getCurrentUser() {
        String userid = RequestUtil.getUserIdFromToken();
        String name = loginDao.getName(userid);
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        return result;
    }
}
