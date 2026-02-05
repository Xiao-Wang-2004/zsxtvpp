package com.wang.zsxt.orderManagement.service;

import com.wang.zsxt.pojo.orderManagement.CreatePojo;
import com.wang.zsxt.tool.Response;

public interface CreateService {

    Response<Object> getOrder(CreatePojo param);

    Response<Object> related(CreatePojo param);

    Response<Object> add(CreatePojo param);
}
