package com.wang.zsxt.orderManagement.service.impl;

import com.wang.zsxt.orderManagement.dao.CreateDao;
import com.wang.zsxt.orderManagement.service.CreateService;
import com.wang.zsxt.pojo.orderManagement.CreatePojo;
import com.wang.zsxt.tool.Response;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Service
public class CreateServiceImpl implements CreateService {

    @Autowired
    private CreateDao createDao;


    @Override
    public Response<Object> getOrder(CreatePojo param) {
        LocalDate now = LocalDate.now();
        String time = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        int count = createDao.getOrderCount(time,param.getUserid());
        count ++;

        HashMap<String,String> data = new HashMap<>();
        if(count >= 10) {
             data.put("orderid","order-" + time + "-" + count);
        }else{
            data.put("orderid","order-" + time + "-0" + count);
        }

        return Response.success(data);
    }

    @Override
    public Response<Object> related(CreatePojo param) {
        HashMap<String,String> data = createDao.getinfo(param);
        return Response.success(data);
    }

    @Override
    public Response<Object> add(CreatePojo param) {
        try {
            createDao.add(param);
            return Response.success("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("添加失败");
        }

    }
}
