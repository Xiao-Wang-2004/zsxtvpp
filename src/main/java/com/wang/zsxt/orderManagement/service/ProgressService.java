package com.wang.zsxt.orderManagement.service;

import com.wang.zsxt.pojo.orderManagement.ProgressPojo;
import com.wang.zsxt.tool.Response;

public interface ProgressService {
    Response<Object> list(ProgressPojo param);
}
