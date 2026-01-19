package com.wang.zsxt.infomation.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.zsxt.infomation.dao.MoldDao;
import com.wang.zsxt.infomation.service.MoldService;
import com.wang.zsxt.pojo.infomation.MoldPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MoldSerciceImpl implements MoldService {

    @Autowired
    private MoldDao moldDao;

    @Override
    public Response<PageInfo<HashMap<String, Object>>> list(MoldPojo moldPojo) {
        // 从moldPojo中获取分页参数
        Integer page = moldPojo.getPage();
        Integer size = moldPojo.getSize();

        // 设置分页参数
        if (page != null && size != null) {
            PageHelper.startPage(page, size);
        }

        List<HashMap<String, Object>> data = moldDao.getList(moldPojo);
        // 返回分页结果
        return Response.success(new PageInfo<>(data));
    }

    @Override
    public Response<String> update(MoldPojo moldPojo) {
        try {
            if (moldDao.getInfo(moldPojo) > 0) {
                moldDao.updateInfo(moldPojo);
                return Response.success("修改成功");
            } else {
                moldDao.insertInfo(moldPojo);
                return Response.success("添加成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("操作失败");
        }
    }

    @Override
    public Response<String> delete(MoldPojo moldPojo) {
        try{
            for (String moldid : moldPojo.getMoldids()) {
                if(moldDao.getInfo2(moldid, moldPojo.getUserid()) > 0){
                    moldDao.deleteInfo(moldid, moldPojo.getUserid());
                }
            }
            return Response.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("操作失败");
        }
    }

    @Override
    public Response<String> keep(MoldPojo moldPojo) {
        try {
            for (String moldid : moldPojo.getMoldids()) {
                if (moldDao.getInfo2(moldid, moldPojo.getUserid()) > 0) {
                    moldDao.updateStatus(moldid, moldPojo.getUserid());
                }
            }
            return Response.success("保存成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return Response.error("操作失败");
        }
    }
}
