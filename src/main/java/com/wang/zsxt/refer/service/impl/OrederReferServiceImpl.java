package com.wang.zsxt.refer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.zsxt.pojo.refer.OrederReferPojo;
import com.wang.zsxt.refer.dao.OrederReferDao;
import com.wang.zsxt.refer.service.OrederReferService;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrederReferServiceImpl implements OrederReferService {

    @Autowired
    private OrederReferDao orederReferDao;


    @Override
    public Response<Object> list(OrederReferPojo param) {
        if(param.getPage() != null && param.getSize() != null){
            PageHelper.startPage(param.getPage(), param.getSize());
        }

        List<HashMap<String, Object>> list = orederReferDao.list(param);

        return Response.success(PageInfo.of(list));
    }
}
