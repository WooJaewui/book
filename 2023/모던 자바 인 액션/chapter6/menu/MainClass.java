package chapter6.menu;

import chapter5.menu.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {

        // Stream.generate( () -> 10).limit(5).collect()

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


        /*long howManyDishes = menu.stream().collect(Collectors.counting());

        System.out.println("howManyDishes = " + howManyDishes);*/

        /*// 문자열 연결.
        String result = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println("result = " + result);*/

        /*// 합계.
        int total = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println("total = " + total);*/

        /*// 합계2.
        int total = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("total = " + total);*/

        /*// 연습문제 6-1. (209페이지)
        String str = menu.stream()
                .collect(Collectors.reducing((a,b)-> a.getName() + b.getName())).get();*/


        /*// 그룹핑하기 - 210page.
        Map<Dish.Type, List<Dish>> map = menu.stream().collect(Collectors.groupingBy(Dish::getType));*/

        /*// 그룹핑하기 - 211page.
        Map<String, List<Dish>> map = menu.stream().collect(Collectors.groupingBy( dish ->
                {
                    if (dish.getCalories() < 400) return "low";
                    else if (dish.getCalories() > 600) return "high";
                    else return "middle";
                }
        ));

        Set<String> keys = map.keySet();

        for(String key : keys) {
            List<Dish> values = map.get(key);
            for(Dish value : values) {
                System.out.println("key = " + key + ", value = " + value);
            }
        }*/

        /*// 컬렉터 에제 - 219page.
        Map<Dish.Type, Set<String>> type = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.mapping(dish -> {
                            if(dish.getCalories() < 400) return "low";
                            else if (dish.getCalories() < 600) return "middle";
                            else return "high";
                        }, Collectors.toSet()))
                );*/


        // 퀴즈 6-2 - 221~222page.
        // 1. Map<Boolean, Map<Boolean, List<Dish>>>
        // 2. Map<Boolean, Map<Boolean, List<Dish>>> ????
        // 3. Map<Boolean, Integer>



    }

}


