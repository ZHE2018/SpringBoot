package com.quartz.quartz.config;

import com.quartz.quartz.service.Job2;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

@Configuration
public class QuzrtzConfig {
    // 包装定时任务
    @Bean
    MethodInvokingJobDetailFactoryBean jobDetail1(){
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetBeanName("job1");
        bean.setTargetMethod("sayHello");
        return bean;
    }
    // 包装定时任务
    @Bean
    JobDetailFactoryBean jobDetail2(){
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(Job2.class);
        JobDataMap dataMap = new JobDataMap();
        dataMap.put("name","sang");
        bean.setJobDataMap(dataMap);
        bean.setDurability(true);
        return bean;
    }
    // 设置触发器
    @Bean
    SimpleTriggerFactoryBean simpleTrigger(){
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setJobDetail(jobDetail1().getObject()); // 传入包装的定时任务
        //显示的设置定时
        bean.setRepeatCount(3);
        bean.setStartDelay(1000);
        bean.setRepeatInterval(2000);
        return bean;
    }
    // 包装定时任务
    @Bean
    CronTriggerFactoryBean cronTrigger(){
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setJobDetail(jobDetail2().getObject()); // 传入包装的定时任务
        // 使用Cron表达式设置定时
        bean.setCronExpression("* * * * * ?");
        return bean;
    }
    // 配置触发器
    @Bean
    SchedulerFactoryBean schedulerBean(){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        SimpleTrigger simpleTrigger = simpleTrigger().getObject();
        CronTrigger cronTrigger = cronTrigger().getObject();
        bean.setTriggers(simpleTrigger, cronTrigger);
        return bean;
    }
}
