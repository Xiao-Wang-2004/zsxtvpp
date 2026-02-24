package com.wang.zsxt.refer.dao;

import com.wang.zsxt.pojo.refer.OutReferPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OutReferDao {
    List<HashMap<String, Object>> list(OutReferPojo param);
}
