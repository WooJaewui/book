package chapter15.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int x = 1337;


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> y = executorService.submit(() -> f(x));
        Future<Integer> z = executorService.submit(() -> g(x));

        System.out.println(y.get() + z.get());

        executorService.shutdown();

    }

    public static int f(int x) {
        // 여러 가지 처리를 하는 함수.
        return x;
    }

    public static int g(int x) {
        // 여러 가지 처리를 하는 함수.
        return x;
    }


}
