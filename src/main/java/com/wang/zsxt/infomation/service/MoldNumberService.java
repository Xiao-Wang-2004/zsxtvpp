package com.wang.zsxt.infomation.service;

import com.github.pagehelper.PageInfo;
import com.wang.zsxt.pojo.infomation.MoldNumberPojo;
import com.wang.zsxt.tool.Response;

import java.util.HashMap;
import java.util.List;

public interface MoldNumberService {
    Response<PageInfo<HashMap<String, Object>>> list(MoldNumberPojo param);

    Response<String> update(MoldNumberPojo moldNumberPojo);

    Response<String> delete(MoldNumberPojo moldNumberPojo);
}
