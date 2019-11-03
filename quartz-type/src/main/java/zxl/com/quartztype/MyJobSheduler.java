package zxl.com.quartztype;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJobSheduler {
    public static void main(String[] args) {
        try {
            Date startDate = getDate1();
            JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("myJob").build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                    .startAt(startDate)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                    .build();

            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
                    .withSchedule(CronScheduleBuilder.cronSchedule("/2 * * * * ?")).build();

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(job, trigger);
//            scheduler.scheduleJob(job, cronTrigger);

            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    //获取当天0点时间
    public static Date getDate1(){
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(java.util.Calendar.HOUR_OF_DAY, 21);//控制时
        cal.set(java.util.Calendar.MINUTE, 35);//控制分
        cal.set(java.util.Calendar.SECOND, 0);//控制秒
        return cal.getTime();
    }
}
