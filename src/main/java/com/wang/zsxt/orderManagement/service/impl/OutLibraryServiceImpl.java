package com.wang.zsxt.orderManagement.service.impl;

import com.wang.zsxt.orderManagement.dao.OutLibraryDao;
import com.wang.zsxt.orderManagement.service.OutLibraryService;
import com.wang.zsxt.pojo.orderManagement.OutLibraryPojo;
import com.wang.zsxt.tool.Response;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OutLibraryServiceImpl implements OutLibraryService {

    @Autowired
    private OutLibraryDao outLibraryDao;


    @Override
    public Response<Object> getList(@RequestBody OutLibraryPojo param) {
        List<HashMap<String,Object>> list = outLibraryDao.getList(param);

        return Response.success(list);
    }
}
