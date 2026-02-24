package com.wang.zsxt.refer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.zsxt.pojo.refer.OutReferPojo;
import com.wang.zsxt.refer.dao.OutReferDao;
import com.wang.zsxt.refer.service.OutReferService;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OutReferServiceImpl implements OutReferService {

    @Autowired
    private OutReferDao outReferDao;


    @Override
    public Response<Object> list(OutReferPojo param) {
        if(param.getPage() != null && param.getSize() != null){
            PageHelper.startPage(param.getPage(), param.getSize());
        }

        List<HashMap<String, Object>> list = outReferDao.list(param);

        return Response.success(PageInfo.of(list));
    }
}
