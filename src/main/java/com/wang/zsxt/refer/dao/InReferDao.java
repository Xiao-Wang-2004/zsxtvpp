package com.wang.zsxt.refer.dao;

import com.wang.zsxt.pojo.refer.InReferPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface InReferDao {
    List<HashMap<String, Object>> list(InReferPojo param);
}
