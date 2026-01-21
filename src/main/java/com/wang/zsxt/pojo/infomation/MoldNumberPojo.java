package com.wang.zsxt.pojo.infomation;

import com.wang.zsxt.pojo.RequestBody;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MoldNumberPojo extends RequestBody {

    private Integer page;

    private Integer size;

    private String moldid;

    private String numberid;

    private String part;

    private String quantity;

    private String remarks;

    private List<String> moldids;
}
