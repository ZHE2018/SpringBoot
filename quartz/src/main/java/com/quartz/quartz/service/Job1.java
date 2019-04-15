package com.quartz.quartz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
// 配置定时任务
@Component
public class Job1 {
    static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    public void sayHello(){
        System.out.println("定时任务[Job1]: "+format.format(new Date()));
    }
}
