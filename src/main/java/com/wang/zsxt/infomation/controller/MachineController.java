package com.wang.zsxt.infomation.controller;

import com.github.pagehelper.PageInfo;
import com.wang.zsxt.infomation.service.MachineService;
import com.wang.zsxt.pojo.infomation.MachinePojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/information/machine")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @PostMapping("/list")
    public Response<PageInfo<HashMap<String, Object>>> list(@RequestBody MachinePojo param){
        return machineService.list(param);
    }

    @PostMapping("/update")
    public Response<String> update(@RequestBody MachinePojo param){
        return machineService.update(param);
    }

    @PostMapping("/delete")
    public Response<String> delete(@RequestBody MachinePojo param){
        return machineService.delete(param);
    }
}
