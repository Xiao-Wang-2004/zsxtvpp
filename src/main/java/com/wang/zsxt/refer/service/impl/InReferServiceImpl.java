package com.wang.zsxt.refer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.zsxt.pojo.refer.InReferPojo;
import com.wang.zsxt.refer.dao.InReferDao;
import com.wang.zsxt.refer.service.InReferService;
import com.wang.zsxt.tool.Response;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class InReferServiceImpl implements InReferService {

    @Autowired
    private InReferDao inReferDao;


    @Override
    public Response<Object> list(InReferPojo param) {
        if(param.getPage() != null && param.getSize() != null){
            PageHelper.startPage(param.getPage(), param.getSize());
        }

        List<HashMap<String, Object>> list = inReferDao.list(param);

        return Response.success(PageInfo.of(list));
    }
}
