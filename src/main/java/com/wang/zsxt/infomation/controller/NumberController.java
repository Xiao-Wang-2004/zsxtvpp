package com.wang.zsxt.infomation.controller;

import com.github.pagehelper.PageInfo;
import com.wang.zsxt.infomation.service.NumberService;
import com.wang.zsxt.pojo.infomation.NumberPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/information/number")
public class NumberController {

    @Autowired
    private NumberService numberService;

    @PostMapping("/list")
    private Response<PageInfo<HashMap<String, Object>>> list(@RequestBody NumberPojo param) {
        return numberService.list(param);
    }

    @PostMapping("/update")
    private Response<String> update(@RequestBody NumberPojo numberPojo) {
        return numberService.update(numberPojo);
    }

    @PostMapping("/delete")
    private Response<String> delete(@RequestBody NumberPojo numberPojo) {
        return numberService.delete(numberPojo);
    }
}
