package chapter15.sleep;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        work1();

        executorService.schedule(ScheduledExecutorServiceExample::work2, 10, TimeUnit.SECONDS);

        executorService.shutdown();

    }

    public static void work1() {
        System.out.println("work1");
    }

    public static void work2() {
        System.out.println("work2");
    }

}
