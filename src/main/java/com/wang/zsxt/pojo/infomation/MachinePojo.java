package com.wang.zsxt.pojo.infomation;

import com.wang.zsxt.pojo.RequestBody;
import com.wang.zsxt.tool.Response;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class MachinePojo extends RequestBody {

    private Integer page;

    private Integer size;

    private String machineid;

    private String brand;

    private int ton;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;

    private int status;

    private List<String> machineids;
}
