package chapter6.prime;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainClass {

    public static void main(String[] args) {






    }

    public boolean isPrime(int candidate) {
        int candidateRoot = (int)Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
    }

    // 퀴즈 6-3 - 233page.
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for(A item : list) {
            if(!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }

}
