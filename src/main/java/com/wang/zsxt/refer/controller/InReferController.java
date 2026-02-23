package com.wang.zsxt.refer.controller;

import com.wang.zsxt.pojo.refer.InReferPojo;
import com.wang.zsxt.refer.service.InReferService;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refer/in")
public class InReferController {

    @Autowired
    private InReferService inReferService;

    @RequestMapping("/list")
    public Response<Object> list(@RequestBody InReferPojo param) {
        return inReferService.list(param);
    }
}
