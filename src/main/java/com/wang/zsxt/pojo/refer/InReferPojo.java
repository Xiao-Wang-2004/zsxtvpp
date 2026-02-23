package com.wang.zsxt.pojo.refer;

import com.wang.zsxt.pojo.RequestBody;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class InReferPojo extends RequestBody {

    private Integer page;

    private Integer size;

    private String entryid;

    private String orderid;

    private String location;

    private String username;

    private Integer count;

    private LocalDate date;

}
