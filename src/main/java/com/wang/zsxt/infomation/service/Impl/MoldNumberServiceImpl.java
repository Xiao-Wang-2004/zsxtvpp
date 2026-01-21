package com.wang.zsxt.infomation.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.zsxt.infomation.dao.MoldNumberDao;
import com.wang.zsxt.infomation.service.MoldNumberService;
import com.wang.zsxt.pojo.infomation.MoldNumberPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class MoldNumberServiceImpl implements MoldNumberService {

    @Autowired
    private MoldNumberDao moldNumberDao;

    @Override
    public Response<PageInfo<HashMap<String, Object>>> list(MoldNumberPojo param) {

        Integer page = param.getPage();
        Integer size = param.getSize();

        if(page != null && size != null){
            PageHelper.startPage(page, size);
        }

        List<HashMap<String, Object>> list = moldNumberDao.list(param);
        return Response.success("查询成功", new PageInfo(list));

    }

    @Override
    public Response<String> update(MoldNumberPojo moldNumberPojo) {
        try {
            if(moldNumberDao.getInfo(moldNumberPojo) > 0){
                moldNumberDao.updateInfo(moldNumberPojo);
                return Response.success("修改成功");
            }else{
                moldNumberDao.insertInfo(moldNumberPojo);
                return Response.success("添加成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("操作失败");
        }
    }

    @Override
    public Response<String> delete(MoldNumberPojo moldNumberPojo) {
        try {
            for (String moldid : moldNumberPojo.getMoldids()) {
                if(moldNumberDao.getInfo(moldid, moldNumberPojo.getUserid()) > 0){
                    moldNumberDao.deleteInfo(moldid, moldNumberPojo.getUserid());
                }
            }
            return Response.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("操作失败");
        }
    }
}
