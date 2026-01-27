package com.wang.zsxt.infomation.controller;

import com.github.pagehelper.PageInfo;
import com.wang.zsxt.infomation.service.ProductService;
import com.wang.zsxt.pojo.infomation.ProductPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/information/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/list")
    public Response<PageInfo<HashMap<String, Object>>> list(@RequestBody ProductPojo param){
        return productService.list(param);
    }

    @PostMapping("/update")
    public Response<String> update(@RequestBody ProductPojo productPojo){
        return productService.update(productPojo);
    }

    @PostMapping("/delete")
    public Response<String> delete(@RequestBody ProductPojo productPojo){
        return productService.delete(productPojo);
    }
}
