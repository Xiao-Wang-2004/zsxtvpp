package com.wang.zsxt.infomation.service;

import com.github.pagehelper.PageInfo;
import com.wang.zsxt.pojo.infomation.MachinePojo;
import com.wang.zsxt.tool.Response;

import java.util.HashMap;

public interface MachineService {
    Response<PageInfo<HashMap<String, Object>>> list(MachinePojo param);

    Response<String> update(MachinePojo param);

    Response<String> delete(MachinePojo param);
}
