package chapter15.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class CFComplete {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int x = 1337;

        CompletableFuture<Integer> a = new CompletableFuture<>();
        executorService.submit(() -> a.complete(f(x)));
        int b = g(x);

        System.out.println(a.get() + b);

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
