package chapter9.debugging;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoggingMainClass {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8);

        List<Integer> collect = integers.stream()
                .parallel()
                .peek(integer -> System.out.println("integer1 = " + integer))
                .map(integer -> integer + 5)
                .peek(integer -> System.out.println("integer2 = " + integer))
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);
    }

}
