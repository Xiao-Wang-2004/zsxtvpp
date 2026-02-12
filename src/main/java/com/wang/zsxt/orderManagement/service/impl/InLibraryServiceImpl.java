package com.wang.zsxt.orderManagement.service.impl;

import com.wang.zsxt.orderManagement.dao.InLibraryDao;
import com.wang.zsxt.orderManagement.service.InLibraryService;
import com.wang.zsxt.pojo.orderManagement.InLibraryPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@Service
public class InLibraryServiceImpl implements InLibraryService {

    @Autowired
    private InLibraryDao inLibraryDao;

    @Override
    public Response<Object> getEntryid(InLibraryPojo param) {
        LocalDate now = LocalDate.now();
        String time = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        int count = inLibraryDao.getEntryCount(time,param.getUserid());
        count ++;

        HashMap<String,Object> data = new HashMap<>();
        if(count >= 10) {
            data.put("entryid","entry-" + time + "-" + count);
        }else{
            data.put("entryid","entry-" + time + "-0" + count);
        }

        List<HashMap<String,Object>> orderList = inLibraryDao.getOrderList(param);
        data.put("orderList",orderList);

        return Response.success(data);
    }

    @Override
    public Response<Object> add(InLibraryPojo param) {
        try {
            if (inLibraryDao.getEntry(param) > 0) {
                return Response.error("该订单已入库");
            } else {
                inLibraryDao.add(param);
                return Response.success("入库成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("入库失败");
        }
    }
}
