package com.wang.zsxt.infomation.service;

import com.github.pagehelper.PageInfo;
import com.wang.zsxt.pojo.infomation.MoldPojo;
import com.wang.zsxt.tool.Response;

import java.util.HashMap;

public interface MoldService {
    Response<PageInfo<HashMap<String, Object>>> list(MoldPojo moldPojo);

    Response<String> update(MoldPojo moldPojo);

    Response<String> delete(MoldPojo moldPojo);

    Response<String> keep(MoldPojo moldPojo);

    void keepMold();
}
