package com.wang.zsxt.refer.service;

import com.wang.zsxt.pojo.refer.OrederReferPojo;
import com.wang.zsxt.tool.Response;

public interface OrederReferService {
    Response<Object> list(OrederReferPojo param);
}
