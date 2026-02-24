package com.wang.zsxt.refer.service;

import com.wang.zsxt.pojo.refer.OutReferPojo;
import com.wang.zsxt.tool.Response;

public interface OutReferService {
    Response<Object> list(OutReferPojo param);
}
