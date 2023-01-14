package chapter8.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {

        /*List<String> list = Arrays.asList("hi", "hello");

        list.add("hihihi");

        System.out.println("list = " + list);*/


        /*List<String> list2 = List.of("hi", "hello");

        list2.add("hihihi");

        System.out.println("list2 = " + list2);*/

        /*Set<String> strings = Set.of("hi", "Hello", "hi");

        // strings.add("hihihi");

        System.out.println("strings = " + strings);*/


        Map<String, Integer> stringIntegerMap = Map.ofEntries(Map.entry("hi", 10), Map.entry("world", 20));

        System.out.println("stringIntegerMap = " + stringIntegerMap);


    }

}
