package com.wang.zsxt.pojo.orderManagement;

import com.wang.zsxt.pojo.RequestBody;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InLibraryPojo extends RequestBody {

    private String entryid;

    private String orderid;

    private Integer count;

    private String location;


}
