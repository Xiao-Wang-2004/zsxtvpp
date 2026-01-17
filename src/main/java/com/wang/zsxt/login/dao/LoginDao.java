package com.wang.zsxt.login.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.Objects;

@Mapper
public interface LoginDao {
    int login(HashMap<String,Object> param);

    String getName(String username);
}
