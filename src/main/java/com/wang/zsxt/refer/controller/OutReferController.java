package com.wang.zsxt.refer.controller;

import com.wang.zsxt.pojo.refer.OutReferPojo;
import com.wang.zsxt.refer.service.OutReferService;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refer/out")
public class OutReferController {

    @Autowired
    private OutReferService outReferService;

    @PostMapping("/list")
    public Response<Object> list(@RequestBody OutReferPojo param) {
        return outReferService.list(param);
    }
}
