package com.wang.zsxt.orderManagement.controller;

import com.wang.zsxt.orderManagement.service.OutLibraryService;
import com.wang.zsxt.pojo.orderManagement.OutLibraryPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order_management/library")
public class OutLibraryController {

    @Autowired
    private OutLibraryService outLibraryService;

    @PostMapping("/getList")
    public Response<Object> getList(@RequestBody OutLibraryPojo param) {
        return outLibraryService.getList(param);
    }

    @PostMapping("/out")
    public Response<Object> out(@RequestBody OutLibraryPojo param) {
        return outLibraryService.out(param);
    }

}
