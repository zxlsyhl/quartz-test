package zxl.com.jdktypescheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyScheduledTask implements Runnable{
    public void run() {
        System.out.println(Thread.currentThread().getName()+":now "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
