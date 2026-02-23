package com.wang.zsxt.pojo.refer;

import com.wang.zsxt.pojo.RequestBody;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class OrederReferPojo extends RequestBody {

    private Integer page;

    private Integer size;

    private String orderid;

    private String unit_name;

    private LocalDate delivery_date;

    private LocalDate order_date;

    private String machineid;

    private String product_name;

    private Integer type;

}
