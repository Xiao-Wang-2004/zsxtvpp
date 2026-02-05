package com.wang.zsxt.orderManagement.controller;

import com.wang.zsxt.orderManagement.service.CreateService;
import com.wang.zsxt.pojo.orderManagement.CreatePojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order_management/create")
public class CreateController {

    @Autowired
    private CreateService createService;

    @PostMapping("/getOrder")
    public Response<Object> getOrder(@RequestBody CreatePojo param) {
        return createService.getOrder(param);
    }

    @PostMapping("/related")
    public Response<Object> related(@RequestBody CreatePojo param) {
        return createService.related(param);
    }

    @PostMapping("/add")
    public Response<Object> add(@RequestBody CreatePojo param) {
        return createService.add(param);
    }

}
