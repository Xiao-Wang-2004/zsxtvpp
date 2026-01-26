package com.wang.zsxt.infomation.dao;

import com.wang.zsxt.pojo.infomation.MachinePojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MachineDao {
    List<HashMap<String, Object>> list(MachinePojo param);

    int getInfo(MachinePojo param);

    void updateInfo(MachinePojo param);

    void insertInfo(MachinePojo param);

    int getInfo(String machineid,String userid);

    void deleteInfo(String machineid, String userid);
}
