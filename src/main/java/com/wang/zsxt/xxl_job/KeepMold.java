package com.wang.zsxt.xxl_job;

import com.wang.zsxt.infomation.service.MoldService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.context.XxlJobHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class KeepMold {

    @Autowired
    private MoldService moldService;

    Logger logger = Logger.getLogger(KeepMold.class.getName());

    @XxlJob("needKepp")
    public void keepMoldJob() {
        logger.info("开始执行needKeep任务...");

        try {
            // 执行具体任务
            moldService.keepMold();
            logger.info("needKepp任务执行成功"); // 使用构造函数
        } catch (Exception e) {
            logger.warning("needKepp任务执行失败: " + e.getMessage());
        }
    }

    private void doKeepMoldLogic() {
        // 实现具体的保模逻辑
        logger.info("执行needKepp操作...");
    }
}