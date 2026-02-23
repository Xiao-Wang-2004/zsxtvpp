package com.wang.zsxt.pojo.orderManagement;

import com.wang.zsxt.pojo.RequestBody;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Setter
@Getter
public class OutLibraryPojo extends RequestBody {

    private List<HashMap<String,Object>> list;
}
