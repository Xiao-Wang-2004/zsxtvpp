package com.wang.zsxt.pojo.orderManagement;

import com.wang.zsxt.pojo.RequestBody;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CreatePojo extends RequestBody {

    private String orderid;

    private String unitid;

    private Date delivery_date;

    private String productid;

    private Integer order_count;

    private String machineid;

    private String remark;
}
