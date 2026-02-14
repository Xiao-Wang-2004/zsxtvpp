package com.wang.zsxt.orderManagement.service.impl;

import com.wang.zsxt.orderManagement.dao.ProgressDao;
import com.wang.zsxt.orderManagement.service.ProgressService;
import com.wang.zsxt.pojo.orderManagement.ProgressPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService {

    @Autowired
    private ProgressDao progressDao;

    @Override
    public Response<Object> list(ProgressPojo param) {
        List<HashMap<String,Object>> list = progressDao.list(param);

        for (HashMap<String, Object> map : list) {
            double productCount = ((Number) map.get("product_count")).doubleValue();
            double orderCount = ((Number) map.get("order_count")).doubleValue();

            double rate = productCount / orderCount;
            int rate2 = (int) Math.round(rate * 100);

            map.put("rate", rate2);
        }

        return Response.success(list);
    }
}
