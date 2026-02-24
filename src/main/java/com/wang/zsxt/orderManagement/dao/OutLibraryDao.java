package com.wang.zsxt.orderManagement.dao;

import com.wang.zsxt.pojo.orderManagement.OutLibraryPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OutLibraryDao {
    List<HashMap<String, Object>> getList(OutLibraryPojo param);

    List<Integer> getCount(String orderid, String userid);

    void out(HashMap<String, Object> param2);

    int getCount2(String time, String userid);

    void addOut(HashMap<String, Object> param3);
}
