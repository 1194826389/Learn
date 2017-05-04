package com.learn.basicthread.scheduledexecutor;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hechao on 2017/5/4.
 */
public class GreenhouseScheduler {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";
    static List<DataPoint> data = Collections.synchronizedList(new ArrayList<DataPoint>());

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String thermostat) {
        this.thermostat = thermostat;
    }

    // 创建线程池，共10个线程
    ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);
    public void setScheduler(Runnable event,long delay) {
        // 只运行一次
        scheduler.schedule(event,delay,TimeUnit.MILLISECONDS);
    }

    public void repeat(Runnable event,long initialDelay,long period) {
        // 重复运行多次（period）
        scheduler.scheduleAtFixedRate(event,initialDelay,period,TimeUnit.MILLISECONDS);
    }

    class Lighton implements Runnable {

        @Override
        public void run() {
            // 打开灯
            System.out.println(Thread.currentThread() + "Turning on lights");
            light = true;
        }
    }

    class LightOff implements Runnable {

        @Override
        public void run() {
            // 关上灯
            System.out.println(Thread.currentThread() + "Turning off lights");
            light = true;
        }
    }

    class WaterOn implements Runnable {

        @Override
        public void run() {
            // 打开温室水
            System.out.println(Thread.currentThread() + "Turning greenhouse water on");
            water = true;
        }
    }

    class WaterOff implements Runnable {

        @Override
        public void run() {
            // 关闭温室水
            System.out.println(Thread.currentThread() + "Turning greenhouse water off");
            water = true;
        }
    }

    class ThermostatNight implements Runnable {
        @Override
        public void run() {
            // 设置恒温器为晚上
            System.out.println(Thread.currentThread() + "Thermostat to night setting");
            setThermostat("night");
        }
    }

    class ThermostatDay implements Runnable {
        @Override
        public void run() {
            // 设置恒温器为白天
            System.out.println(Thread.currentThread() + "Thermostat to day setting");
            setThermostat("day");
        }
    }

    class Bell implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread() + "Bing");;
        }
    }

    class Terminate implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread() + "Terminating");
            scheduler.shutdownNow();
            // 自从scheduler调用了shutdownNow方法，就必须开启另外的一个任务去做这个事情

            new Thread() {
                public void run() {
                    for (DataPoint d : data) {
                        System.out.println(d);
                    }
                }
            }.start();
        }
    }


    // 新功能：data collection
    static class DataPoint {
        final Calendar time;
        final float temperature;// 温度
        final float humidity;// 湿度


        public DataPoint(Calendar calendar,float temperature,float humidity) {
            this.time = calendar;
            this.temperature = temperature;
            this.humidity = humidity;
        }



        @Override
        public String toString() {
            return time.getTime() + String.format(" temperature: %1$.1f humidity: %2$.2f",temperature,humidity);
        }

        private Calendar lastTime = Calendar.getInstance();

        {
            // 调整date为半个小时
            lastTime.set(Calendar.MINUTE,30);
            lastTime.set(Calendar.SECOND,0);
        }
        private float lastTemp = 65.0F;
        private int tempDirection = +1;
        private float lastHumidity = 50.0F;
        private int humidityDirection = +1;
        private Random rand = new Random(47);



        class CollectData implements Runnable {

            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "Collecting data");
                synchronized (this) {
                    // 伪装间隔比它更长
                    lastTime.set(Calendar.MINUTE,lastTime.get(Calendar.MINUTE) + 30);

                    // 有五分之一的机会反转方向
                    if (rand.nextInt(5) == 4) {
                        tempDirection = -tempDirection;
                    }
                    // 存储上次的湿度的值
                    lastTemp = lastTemp + tempDirection * (1.0F + rand.nextFloat());

                    if (rand.nextInt(5) == 4) {
                        humidityDirection = -humidityDirection;
                    }

                    lastHumidity = lastHumidity + rand.nextFloat();

                    // Calendar 必须使用clone()方法，否则所有的DataPoint将会持有同一个lastTime.
                    data.add(new DataPoint((Calendar)lastTime.clone(),lastTemp,lastHumidity));

                }
            }
        }
    }


}
