package com.wang.zsxt.orderManagement.dao;

import com.wang.zsxt.pojo.orderManagement.InLibraryPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface InLibraryDao {
    int getEntryCount(String time, String userid);

    List<HashMap<String, Object>> getOrderList(InLibraryPojo param);

    int getEntry(InLibraryPojo param);

    void add(InLibraryPojo param);
}
