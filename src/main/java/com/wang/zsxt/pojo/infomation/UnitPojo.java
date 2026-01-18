package com.wang.zsxt.pojo.infomation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.wang.zsxt.pojo.RequestBody;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Getter
@Setter
public class UnitPojo extends RequestBody {

    private String id;

    private String unitid;

    private String name;

    private String person;

    private String phone;

    private String address;

    private int type;

    private Integer page;

    private Integer size;

    private List<String> unitids;

}
