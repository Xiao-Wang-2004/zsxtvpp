package com.wang.zsxt.pojo;

import com.wang.zsxt.tool.RequestUtil;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RequestBody {

    private String userid = RequestUtil.getUserIdFromToken();

    private LocalDateTime time = LocalDateTime.now();
}
