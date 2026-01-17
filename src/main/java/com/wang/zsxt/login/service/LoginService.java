package com.wang.zsxt.login.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wang.zsxt.pojo.login.LoginPojo;
import com.wang.zsxt.tool.Response;

import java.util.HashMap;

public interface LoginService {
    Response<Object> login(LoginPojo info) throws JsonProcessingException;

    HashMap<String,Object> getCurrentUser();
}
