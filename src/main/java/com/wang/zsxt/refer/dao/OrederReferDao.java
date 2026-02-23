package com.wang.zsxt.refer.dao;

import com.wang.zsxt.pojo.refer.OrederReferPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrederReferDao {
    List<HashMap<String, Object>> list(OrederReferPojo param);
}
