package com.wang.zsxt.infomation.controller;

import com.github.pagehelper.PageInfo;
import com.wang.zsxt.infomation.service.MoldService;
import com.wang.zsxt.pojo.infomation.MoldPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/infomation/mold")
public class MoldController {

    @Autowired
    private MoldService moldService;

    @PostMapping("/list")
    public Response<PageInfo<HashMap<String, Object>>> list(@RequestBody MoldPojo moldPojo) {
        return moldService.list(moldPojo);
    }

    @PostMapping("/update")
    public Response<String> update(@RequestBody MoldPojo moldPojo) {
        return moldService.update(moldPojo);
    }

    @PostMapping("/delete")
    public Response<String> delete(@RequestBody MoldPojo moldPojo) {
        return moldService.delete(moldPojo);
    }

    @PostMapping("/keep")
    public Response<String> keep(@RequestBody MoldPojo moldPojo) {
        return moldService.keep(moldPojo);
    }

}
