package chapter5.menu;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.OTHER)
        );

        // 155page.
        /*List<Dish> test1 = menu.stream()
                .filter(dish -> dish.isVegetarian())
                .collect(Collectors.toList());

        System.out.println(test1);*/


        // 158page.
        /*List<Dish> test = menu.stream()
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .takeWhile(dish -> {
                    System.out.println(dish.getCalories());
                    return dish.getCalories() > 500;
                })
                .collect(Collectors.toList());*/

        // 160 page 테스트.
        /*List<Dish> test = menu.stream()
                .skip(2)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(test);*/


        // 퀴즈 5-1
        /*List<Dish> test = menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(test);*/

        // 163 page.
        /*String[] words = {"Hello", "World"};

        List<Stream<String>> test = Arrays.stream(words)
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(test);*/


        // 164 page.
        /*String[] words = {"Hello", "World"};

        List<String> test = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(test);*/

        // 연습
        /*String[] words = {"Hello", "World"};
        List<String> t = Arrays.asList(words);

        for(String t2 : t) {
            String[] t3 = t2.split("");
            for(String t4 : t3) {
                System.out.println(t4);
            }
        }*/

        // 퀴즈 5-2 1번.
        /*Integer[] numbers = {1,2,3,4,5};

        List<Integer> numberList = Arrays.stream(numbers)
                    .map(i -> i*i)
                    .collect(Collectors.toList());

        System.out.println(numberList);*/


        // 퀴즈 5-2 2번.
        /*List<Integer> numberList1 = Arrays.asList(1,2,3);
        List<Integer> numberList2 = Arrays.asList(3,4);

        List<int[]> test2 = numberList1.stream()
                .flatMap(i -> numberList2.stream().map(j -> new int[]{i,j}))
                .collect(Collectors.toList());

        for(int[] i1 : test2) {
            for(int i2 : i1) {
                System.out.println(i2);
            }
        }*/

        // 퀴즈 5-2 3번.
        /*List<Integer> numberList1 = Arrays.asList(1,2,3);
        List<Integer> numberList2 = Arrays.asList(3,4);

        List<int[]> test3 = numberList1.stream()
                .flatMap(i -> numberList2.stream()
                        .filter(j -> (i+j)%3 == 0)
                        .map(j -> new int[]{i,j}
                ))
                .collect(Collectors.toList());

        for(int[] i1 : test3) {
            for(int i2 : i1) {
                System.out.println(i2);
            }
        }*/


        // 연습.
        /*String[][] names = { {"kim", "taeng"}, {"mad", "play"}};

        Arrays.stream(names)
                .map(inner -> Arrays.stream(inner))
                .forEach(name1 -> name1.filter(name -> name.equals("taeng")).forEach(System.out::println));*/


        // 퀴즈 5-3.
        /*int test = menu.stream()
                .map(s -> 1)
                .reduce(0, Integer::sum);

        long test2 = menu.stream()
                        .count();

        System.out.println(test);
        System.out.println(test2);*/



    }
}
