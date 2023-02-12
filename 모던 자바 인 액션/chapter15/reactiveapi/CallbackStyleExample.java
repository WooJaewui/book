package chapter15.reactiveapi;

import java.util.function.Consumer;

public class CallbackStyleExample {

    public static void main(String[] args) {

        int x = 1337;
        Result result = new Result();

        f(x, (y) -> {
            result.left = y;
            System.out.println(result.left + result.right);
        });

        g(x, (z) -> {
            result.right = z;
            System.out.println(result.left + result.right);
        });

    }

    public static int f(int x, Consumer<Integer> consumer) {
        consumer.accept(x);
        return x;
    }

    public static int g(int x, Consumer<Integer> consumer) {
        // 여러 가지 처리를 하는 함수.
        consumer.accept(x);
        return x;
    }



    private static class Result {
        private int left;
        private int right;

    }
}
