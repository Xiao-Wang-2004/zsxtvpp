package com.wang.zsxt.pojo.refer;

import com.wang.zsxt.pojo.RequestBody;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class OutReferPojo extends RequestBody {

    private Integer page;

    private Integer size;

    private String outid;

    private String orderid;

    private String name;

    private int count;

    private LocalDate date;

}
