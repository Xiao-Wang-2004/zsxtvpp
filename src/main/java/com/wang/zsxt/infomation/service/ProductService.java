package com.wang.zsxt.infomation.service;

import com.github.pagehelper.PageInfo;
import com.wang.zsxt.pojo.infomation.ProductPojo;
import com.wang.zsxt.tool.Response;

import java.util.HashMap;

public interface ProductService {
    Response<PageInfo<HashMap<String, Object>>> list(ProductPojo param);

    Response<String> update(ProductPojo productPojo);

    Response<String> delete(ProductPojo productPojo);
}
