package com.wang.zsxt.infomation.dao;

import com.wang.zsxt.pojo.infomation.MoldPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MoldDao {
    List<HashMap<String, Object>> getList(MoldPojo moldPojo);

    int getInfo(MoldPojo moldPojo);

    void updateInfo(MoldPojo moldPojo);

    void insertInfo(MoldPojo moldPojo);

    int getInfo2(String moldid,String userid);

    void deleteInfo(String moldid, String userid);

    void updateStatus(String moldid, String userid);

    List<HashMap<String, Object>> getAllList();

    void needKeep(String moldid, String userid);
}
