package com.wang.zsxt.infomation.dao;

import com.wang.zsxt.pojo.infomation.NumberPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface NumberDao {
    List<HashMap<String, Object>> getList(NumberPojo param);

    int getInfo(NumberPojo numberPojo);

    void updateInfo(NumberPojo numberPojo);

    String  getUnitName(NumberPojo numberPojo);

    void insertInfo(NumberPojo numberPojo);

    void deleteInfo(String numberid, String userid);
}
