package com.wang.zsxt.infomation.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.zsxt.infomation.dao.UnitDao;
import com.wang.zsxt.infomation.service.UnitService;
import com.wang.zsxt.pojo.infomation.UnitPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitDao unitDao;


    @Override
    public PageInfo<HashMap<String, Object>> list(UnitPojo unitPojo) {
        // 从unitPojo中获取分页参数
        Integer page = unitPojo.getPage();
        Integer size = unitPojo.getSize();
        
        // 设置分页参数
        if (page != null && size != null) {
            PageHelper.startPage(page, size);
        }
        
        List<HashMap<String, Object>> data = unitDao.getList(unitPojo);
        // 返回分页结果
        return new PageInfo<>(data);
    }

    @Override
    public String change(UnitPojo unitPojo) {

        try {
            if (unitDao.getInfo(unitPojo) > 0) {
                unitDao.updateInfo(unitPojo);
                return "修改成功";
            } else {
                unitDao.insertInfo(unitPojo);
                return "添加成功";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "操作失败";
        }

    }

    @Override
    public Response<String> delete(UnitPojo unitPojo) {
        try {
            List<String> ids = unitPojo.getUnitids();
            String userid = unitPojo.getUserid();
            for (String unitid : ids) {
                if (unitDao.getInfo2(unitid, userid) > 0) {
                    unitDao.deleteInfo(unitid, userid);
                }
            }
            return Response.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("操作失败");
        }
    }
}
