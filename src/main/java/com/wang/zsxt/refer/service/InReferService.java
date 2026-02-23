package com.wang.zsxt.refer.service;

import com.wang.zsxt.pojo.refer.InReferPojo;
import com.wang.zsxt.tool.Response;

public interface InReferService {
    Response<Object> list(InReferPojo param);
}
