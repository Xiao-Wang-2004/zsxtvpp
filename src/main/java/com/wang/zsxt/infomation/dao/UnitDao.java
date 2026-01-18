package com.wang.zsxt.infomation.dao;

import com.wang.zsxt.pojo.infomation.UnitPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UnitDao {
    List<HashMap<String, Object>> getList(UnitPojo unitPojo);

    int getInfo(UnitPojo unitPojo);

    int getInfo2(String unitid,String userid);

    void updateInfo(UnitPojo unitPojo);

    void deleteInfo(String unitid,String userid);

    void insertInfo(UnitPojo unitPojo);
}
