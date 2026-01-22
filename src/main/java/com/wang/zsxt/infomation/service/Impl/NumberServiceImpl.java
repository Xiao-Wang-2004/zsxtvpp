package com.wang.zsxt.infomation.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.zsxt.infomation.dao.NumberDao;
import com.wang.zsxt.infomation.service.NumberService;
import com.wang.zsxt.pojo.infomation.NumberPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class NumberServiceImpl implements NumberService{

    @Autowired
    private NumberDao numberDao;


    @Override
    public Response<PageInfo<HashMap<String, Object>>> list(NumberPojo param) {
        Integer page = param.getPage();
        Integer size = param.getSize();

        if(page != null && size != null){
            PageHelper.startPage(page, size);
        }

        List<HashMap<String, Object>> data = numberDao.getList(param);
        return Response.success(new PageInfo<>(data));
    }

    @Override
    public Response<String> update(NumberPojo numberPojo) {

        try {
            if(numberDao.getUnitName(numberPojo) == null){
                return Response.error("无当前供应商信息");
            }

            if(numberDao.getInfo(numberPojo) > 0){
                numberDao.updateInfo(numberPojo);
                return Response.success("修改成功");
            }else {
                numberDao.insertInfo(numberPojo);
                return Response.success("添加成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("操作失败");
        }

    }

    @Override
    public Response<String> delete(NumberPojo numberPojo) {
        try {
            for (String numberid : numberPojo.getNumberids()) {
                numberDao.deleteInfo(numberid, numberPojo.getUserid());
            }
            return Response.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("操作失败");
        }
    }
}
