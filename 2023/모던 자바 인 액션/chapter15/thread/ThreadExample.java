package chapter15.thread;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {

        int x = 1337;
        Result result = new Result();

        // 함수.
        Thread t1 = new Thread(() -> { result.left = f(x);});
        Thread t2 = new Thread(() -> { result.right = g(x);});

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(result.left + result.right);


    }

    public static int f(int x) {
        // 여러 가지 처리를 하는 함수.
        return x;
    }

    public static int g(int x) {
        // 여러 가지 처리를 하는 함수.
        return x;
    }

    private static class Result {
        private int left;
        private int right;

    }

}
