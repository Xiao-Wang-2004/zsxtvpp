package com.wang.zsxt.infomation.dao;

import com.wang.zsxt.pojo.infomation.ProductPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProductDao {
    List<HashMap<String, Object>> list(ProductPojo param);

    int getInfo(ProductPojo productPojo);

    int getInfo(String productid,String userid);

    void updateInfo(ProductPojo productPojo);

    void insertInfo(ProductPojo productPojo);

    void deleteInfo(String productid, String userid);
}
