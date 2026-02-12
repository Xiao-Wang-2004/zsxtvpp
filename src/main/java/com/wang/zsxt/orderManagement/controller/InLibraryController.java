package com.wang.zsxt.orderManagement.controller;

import com.wang.zsxt.orderManagement.service.InLibraryService;
import com.wang.zsxt.pojo.orderManagement.InLibraryPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/order_management/library")
public class InLibraryController {

    @Autowired
    private InLibraryService inLibraryService;

    @PostMapping("/getEntryid")
    public Response<Object> getEntryid(@RequestBody InLibraryPojo param) {
        return inLibraryService.getEntryid(param);
    }

    @PostMapping("/add")
    public Response<Object> add(@RequestBody InLibraryPojo param) {
        return inLibraryService.add(param);
    }
}
