package com.wang.zsxt.infomation.service;

import com.github.pagehelper.PageInfo;
import com.wang.zsxt.pojo.infomation.NumberPojo;
import com.wang.zsxt.tool.Response;

import java.util.HashMap;

public interface NumberService {
    Response<PageInfo<HashMap<String, Object>>> list(NumberPojo param);

    Response<String> update(NumberPojo numberPojo);

    Response<String> delete(NumberPojo numberPojo);
}
