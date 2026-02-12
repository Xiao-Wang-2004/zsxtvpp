package com.wang.zsxt.orderManagement.service;

import com.wang.zsxt.pojo.orderManagement.OutLibraryPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.web.bind.annotation.RequestBody;

public interface OutLibraryService {
    Response<Object> getList(@RequestBody OutLibraryPojo param);
}
