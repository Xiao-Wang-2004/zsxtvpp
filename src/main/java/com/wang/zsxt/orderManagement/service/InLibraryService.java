package com.wang.zsxt.orderManagement.service;

import com.wang.zsxt.pojo.orderManagement.InLibraryPojo;
import com.wang.zsxt.tool.Response;

public interface InLibraryService {
    Response<Object> getEntryid(InLibraryPojo param);

    Response<Object> add(InLibraryPojo param);
}
