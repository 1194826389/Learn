package com.learn.basicthread.scheduledexecutor;

import java.util.Calendar;

/**
 * Created by hechao on 2017/5/4.
 * ScheduledThreadPoolExecutor提供预定时间内完成任务的功能，
 * 通过使用schedule()（只调用一次）和 scheduleAtFixedRate()（每隔规则的时间重复执行任务），scheduleWithFixedDelay() (每隔规则的延时重复执行任务？)可以将Runnable对象设置为在将来的某个时刻执行
 */
public class ScheduledExecutorMain {
    public static void main(String[] args) {
        GreenhouseScheduler gh = new GreenhouseScheduler();
        GreenhouseScheduler.DataPoint dataPoint = new GreenhouseScheduler.DataPoint(Calendar.getInstance(),12,12);
        gh.setScheduler(gh.new Terminate(),5000);
        gh.repeat(gh.new Bell(),0,1000);
        gh.repeat(gh.new ThermostatNight(),0,2000);
        gh.repeat(gh.new Lighton(),0,200);
        gh.repeat(gh.new LightOff(),0,400);
        gh.repeat(gh.new WaterOn(),0,600);
        gh.repeat(gh.new WaterOff(),0,800);
        gh.repeat(gh.new ThermostatDay(),0,1400);
        gh.repeat(dataPoint.new CollectData(),500,500);
    }
}
