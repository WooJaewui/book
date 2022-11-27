package chapter2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass {

    public static void main(String[] args) {

        List<Apple> inven = new ArrayList<>();


        // 익명함수 사용 방식.
        filterApples(inven, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });

        // 람다 표현 방식.
        filterApples(inven, (Apple apple)-> Color.RED.equals(apple.getWeight()));


        // Comparator로 정렬하기.
        inven.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));


        // 람다 Comparator로 정렬하기.
        inven.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                o1.getColor().compareTo(o2.getColor());
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });


        // Runnable 사용하기.
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("출력");
            }
        });

        // Runnable 람다 사용하기.
        Thread t2 = new Thread(()-> System.out.println("출력2"));


        // Callable 사용하기.
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> threadName1 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });

        // Callable 람다 사용하기.
        Future<String> threadName2 = executorService.submit(()->Thread.currentThread().getName());




    }

    static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    static void prettyPrintApple(List<Apple> inventory, AppleWeightFilter p) {

        for(Apple apple : inventory) {
            String output = Integer.toString(p.test(apple));
            System.out.println(output);
        }

    }

}
