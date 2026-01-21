package com.wang.zsxt.infomation.controller;

import com.github.pagehelper.PageInfo;
import com.wang.zsxt.infomation.service.MoldNumberService;
import com.wang.zsxt.pojo.infomation.MoldNumberPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/information/mold_number")
public class MoldNumberController {

    @Autowired
    private MoldNumberService moldNumberService;

    @PostMapping("/list")
    public Response<PageInfo<HashMap<String, Object>>> list(@RequestBody MoldNumberPojo param) {
        return moldNumberService.list(param);
    }

    @PostMapping("/update")
    public Response<String> update(@RequestBody MoldNumberPojo moldNumberPojo) {
        return moldNumberService.update(moldNumberPojo);
    }

    @PostMapping("/delete")
    public Response<String> delete(@RequestBody MoldNumberPojo moldNumberPojo) {
        return moldNumberService.delete(moldNumberPojo);
    }
}
