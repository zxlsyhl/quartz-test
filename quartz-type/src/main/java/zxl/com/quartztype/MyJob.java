package zxl.com.quartztype;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob implements Job {
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("执行Quartz定时任务实现, now: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}