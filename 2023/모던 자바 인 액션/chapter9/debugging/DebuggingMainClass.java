package chapter9.debugging;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DebuggingMainClass {

    public static void main(String[] args) {
        /*List<Point> points = Arrays.asList(new Point(12, 2), null);

        points.stream()
                .map(p -> p.getX())
                .forEach(System.out::println);*/

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        List<Integer> collect = numbers.stream().map(DebuggingMainClass::divideByZero).collect(Collectors.toList());

    }

    public static int divideByZero(int n) {
        return n/0;
    }

}
