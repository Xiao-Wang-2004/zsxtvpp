package com.wang.zsxt.pojo.infomation;

import com.wang.zsxt.pojo.RequestBody;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductPojo extends RequestBody {

    private Integer page;

    private Integer size;

    private String productid;

    private String name;

    private String model;

    private String moldid;

    private Double quantity;

    private List<String> productids;

}
