package com.wang.zsxt.infomation.dao;

import com.wang.zsxt.pojo.infomation.MoldNumberPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MoldNumberDao {
    List<HashMap<String, Object>> list(MoldNumberPojo param);

    int getInfo(MoldNumberPojo moldNumberPojo);

    void updateInfo(MoldNumberPojo moldNumberPojo);

    void insertInfo(MoldNumberPojo moldNumberPojo);
    
    int getInfo(String moldid, String userid);

    void deleteInfo(String moldid, String userid);
}
