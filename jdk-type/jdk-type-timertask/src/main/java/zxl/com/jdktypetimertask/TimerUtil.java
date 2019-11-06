package zxl.com.jdktypetimertask;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: Zhangbx
 * @Description:
 * @Date: 2017/12/5
 * @Modified By:
 * @Modified Date:
 */
public class TimerUtil {
    public static void main(String[] args) {
        timer4();
    }

    /**
     * 设定2000毫秒后执行
     */
    public static void timer1(){
        Timer nTimer = new Timer();
        nTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("----设定要指定任务-----");
            }
        },2000);
    }

    /**
     * 延迟5000毫秒，每1000毫秒执行一次
     */
    public static void timer2() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------延迟5000毫秒，每1000毫秒执行一次--------");
            }
        }, 5000, 1000);
    }

    /**
     * 延迟5000毫秒，每1000毫秒执行一次
     */
    public static void timer3() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.err.println("-------延迟5000毫秒，每1000毫秒执行一次--------");
            }
        }, 5000, 1000);
    }
    /**
     * 设置17：56执行任务
     * java.util.Timer.scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
     */
    public static void timer4() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date time = calendar.getTime();

        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            public void run() {
//                System.out.println("-------设定要指定任务--------");
//            }
//        }, time, 1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("-------设定要指定任务--------"+sdf.format(new Date()));
            }
        }, time, 1000*60);// 这里设定将延时每天固定执行
        System.out.println("结束执行");
    }


}


