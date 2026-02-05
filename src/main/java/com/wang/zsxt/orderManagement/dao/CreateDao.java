package com.wang.zsxt.orderManagement.dao;

import com.wang.zsxt.pojo.orderManagement.CreatePojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface CreateDao {
    int getOrderCount(String time, String userid);


    HashMap<String, String> getinfo(CreatePojo param);

    void add(CreatePojo param);
}
