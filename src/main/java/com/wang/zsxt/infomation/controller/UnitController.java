package com.wang.zsxt.infomation.controller;

import com.github.pagehelper.PageInfo;
import com.wang.zsxt.infomation.service.UnitService;
import com.wang.zsxt.pojo.infomation.UnitPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/infomation/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @PostMapping("/list")
    public Response<PageInfo<HashMap<String, Object>>> list(@RequestBody UnitPojo unitPojo) {
        return Response.success(unitService.list(unitPojo));
    }

    @PostMapping("/update")
    public Response<String> change(@RequestBody UnitPojo unitPojo) {
        return Response.success(unitService.change(unitPojo));
    }

    @PostMapping("/delete")
    public Response<String> delete(@RequestBody UnitPojo unitPojo) {
        return unitService.delete(unitPojo);
    }
}
