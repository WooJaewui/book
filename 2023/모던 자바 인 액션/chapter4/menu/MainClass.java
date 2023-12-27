package chapter4.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        /*List<String> threadHisgCaloricDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(threadHisgCaloricDishNames);


        // 외부 반복.
        for(Dish d : menu) {
            System.out.println(d.getName());
        }

        // 내부 반복.
        menu.stream()
                .map(Dish::getName)
                .forEach(System.out::println);

        // 퀴즈 4-1
        List<String> highCalroicDished = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(highCalroicDished);*/


        // 151 page.
        /*List<String> test = menu.stream()
                .filter(dish -> {
                    System.out.println(dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println(dish.getName());
                    return dish.getName();
                })
                .collect(Collectors.toList());*/


        // 퀴즈 4-2.
        long count = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .distinct()
                .limit(3)
                .count();
        System.out.println(count);


    }
}
