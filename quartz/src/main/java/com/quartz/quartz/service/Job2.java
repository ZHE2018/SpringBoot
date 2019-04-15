package com.quartz.quartz.service;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;
// 配置定时任务
public class Job2 extends QuartzJobBean {
    static final SimpleDateFormat format= new SimpleDateFormat("hh:mm:ss");
    private String  name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        System.out.println("定时任务[Job2]: "+format.format(new Date())+" name:"+name);
    }
}
