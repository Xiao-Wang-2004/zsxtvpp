package com.wang.zsxt.infomation.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.zsxt.infomation.dao.ProductDao;
import com.wang.zsxt.infomation.service.ProductService;
import com.wang.zsxt.pojo.infomation.ProductPojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Response<PageInfo<HashMap<String, Object>>> list(ProductPojo param) {
        if(param.getPage() != null && param.getSize() != null)
        {
            PageHelper.startPage(param.getPage(), param.getSize());
        }

        List<HashMap<String, Object>> data = productDao.list(param);

        return Response.success(PageInfo.of(data));
    }

    @Override
    public Response<String> update(ProductPojo productPojo) {
        try{
            if(productDao.getInfo(productPojo) > 0)
            {
                productDao.updateInfo(productPojo);
                return Response.success("修改成功");
            }else {
                productDao.insertInfo(productPojo);
                return Response.success("添加成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("操作失败");
        }
    }

    @Override
    public Response<String> delete(ProductPojo productPojo) {
        try{
            for (String productid : productPojo.getProductids()) {
                if(productDao.getInfo(productid, productPojo.getUserid()) > 0){
                    productDao.deleteInfo(productid, productPojo.getUserid());
                }
            }
            return Response.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("操作失败");
        }
    }
}
