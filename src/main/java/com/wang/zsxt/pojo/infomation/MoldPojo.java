package com.wang.zsxt.pojo.infomation;

import com.wang.zsxt.pojo.RequestBody;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class MoldPojo extends RequestBody{

    private Integer page;

    private Integer size;

    private String moldid;

    private String name;

    private String count;

    private String type;

    private int life;

    private int usedlife;

    private String location;

    private String status;

    private List<String> moldids;


}
