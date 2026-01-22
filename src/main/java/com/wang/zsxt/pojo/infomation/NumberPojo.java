package com.wang.zsxt.pojo.infomation;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
public class NumberPojo extends MoldNumberPojo{

    private Integer page;

    private Integer size;

    private String numberid;

    private String product_name;

    private String brand_name;

    private String color;

    private String unitid;

    private String name;

    private Double inventory;

    private List<String> numberids;
}
