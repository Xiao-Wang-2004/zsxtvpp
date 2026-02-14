package com.wang.zsxt.orderManagement.controller;

import com.wang.zsxt.orderManagement.dao.ProgressDao;
import com.wang.zsxt.orderManagement.service.ProgressService;
import com.wang.zsxt.pojo.orderManagement.ProgressPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order_management/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @PostMapping("/list")
    public Response<Object> list(@RequestBody ProgressPojo param){
        return progressService.list(param);
    }
}
