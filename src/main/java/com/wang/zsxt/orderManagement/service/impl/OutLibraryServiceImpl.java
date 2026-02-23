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

    @Override
    public Response<Object> out(OutLibraryPojo param) {
        try {
            for (HashMap<String, Object> map : param.getList()) {
                HashMap<String, Object> param2 = new HashMap<>() {
                    {
                        put("orderid", map.get("orderid"));
                        put("out_count", map.get("out_count"));
                        put("userid", param.getUserid());
                    }
                };

                outLibraryDao.out(param2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("出库失败");
        }
        return Response.success("出库成功");
    }
}
