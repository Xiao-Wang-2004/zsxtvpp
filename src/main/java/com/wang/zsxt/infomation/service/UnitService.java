package com.wang.zsxt.infomation.service;

import com.github.pagehelper.PageInfo;
import com.wang.zsxt.pojo.infomation.UnitPojo;
import com.wang.zsxt.tool.Response;

import java.util.HashMap;

public interface UnitService {
   PageInfo<HashMap<String, Object>> list(UnitPojo unitPojo);

   String change(UnitPojo unitPojo);

   Response<String> delete(UnitPojo unitPojo);
}
