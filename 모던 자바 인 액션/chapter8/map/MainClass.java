package chapter8.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MainClass {

    public static void main(String[] args) {

        /*Map<String, Object> map = new HashMap();
        Map<String, String> map2 = Map.ofEntries(Map.entry("hi", "hi"));

        map.put("hi", "hi");
        map.put("hello", "hello");


        map.forEach((str, obj) -> System.out.println("str = " + str + "obj = " + obj));


        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(System.out::println);*/

        String friend = "Raphael";

        Map<String, List<String>> map = new HashMap<>();

        map.put("hi", new ArrayList<>());
        map.put("hello", new ArrayList<>());

        /*List<String> movies = map2.get(friend);

        if(movies == null) {
            movies = new ArrayList<>();
            map2.put(friend, movies);
        }

        movies.add("Star wars");

        System.out.println("movies = " + movies);*/

        /*map.computeIfAbsent("Raphael", name -> new ArrayList<>()).add("Star wards");
        map.computeIfPresent("Raphael", (s, strings) -> {
            List<String> result = new ArrayList<>();
            result.add("hello");
            return result;
        });

        System.out.println("map = " + map);*/

        /*ArrayList<String> strings = new ArrayList<>();
        strings.add("hello");
        System.out.println("map = " + map);

        map.replace("hi", strings);
        System.out.println("map = " + map);

        map.replaceAll((s, strings1) -> {strings1.add(s + strings1); return strings1; } );
        System.out.println("map = " + map);*/

        /*Map<String, String> family = Map.ofEntries(Map.entry("Teo", "hi"), Map.entry("Cris", "James"));
        Map<String, String> friends = Map.ofEntries(Map.entry("hwa", "hello"), Map.entry("Cris", "good"));
        Map<String, String> all = new HashMap<>(family);

        System.out.println("all = " + all);

        friends.forEach((k1, v1) -> all.merge(k1, v1, (movie1, movie2) -> movie1 + " & " + movie2));
        System.out.println("all = " + all);*/


        /*Map<String, Long> moviesToCount = new HashMap<>();
        moviesToCount.put("hi", 5L);

        moviesToCount.merge("hi", 1L, (count1, count2) -> count2+count1);

        System.out.println("moviesToCount = " + moviesToCount);*/


        // 퀴즈 8-2 289페이지.
        /*Map<String, Integer> movies = new HashMap<>();
        movies.put("Jame", 20);
        movies.put("Matrix", 15);
        movies.put("Harry Potter", 5);

        movies.entrySet().removeIf(stringIntegerEntry -> stringIntegerEntry.getValue() < 10);

        System.out.println("movies = " + movies);*/


        ConcurrentHashMap<String, Long> map2 = new ConcurrentHashMap<>();

        map2.put("apple", 1L);

        long parallel = 1;


        Optional<Long> maxValue = Optional.ofNullable(map2.reduceValues(parallel, Long::max));

        map2.mappingCount();

        ConcurrentHashMap.KeySetView<String, Long> strings = map2.keySet();

        System.out.println("strings = " + strings);
        System.out.println("map2 = " + map2);

        strings.remove("apple");

        System.out.println("strings = " + strings);
        System.out.println("map2 = " + map2);

        // System.out.println("maxValue = " + maxValue);


    }


}
