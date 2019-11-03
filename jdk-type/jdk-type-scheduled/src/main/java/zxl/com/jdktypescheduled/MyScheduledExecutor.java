package zxl.com.jdktypescheduled;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyScheduledExecutor {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
//        ScheduledThreadPoolExecutor executor = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = new ScheduledThreadPoolExecutor(10);
        executor.scheduleWithFixedDelay(new MyScheduledTask(),1000,1000, TimeUnit.MILLISECONDS);
    }
}
