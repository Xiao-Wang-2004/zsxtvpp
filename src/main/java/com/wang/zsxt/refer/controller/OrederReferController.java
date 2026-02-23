package com.wang.zsxt.refer.controller;

import com.wang.zsxt.pojo.refer.OrederReferPojo;
import com.wang.zsxt.refer.service.OrederReferService;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refer/order")
public class OrederReferController {

    @Autowired
    private OrederReferService orederReferService;

    @PostMapping("/list")
    public Response<Object> list(@RequestBody OrederReferPojo param) {
        return orederReferService.list(param);
    }
}
