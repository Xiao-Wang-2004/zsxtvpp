package com.wang.zsxt.orderManagement.dao;

import com.wang.zsxt.pojo.orderManagement.ProgressPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProgressDao {
    List<HashMap<String, Object>> list(ProgressPojo param);
}
