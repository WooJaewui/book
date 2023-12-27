package chapter5.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");


        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        /*// 문제1.
        List<Transaction> test1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println(test1);


        // 문제2.
        List<String> test2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(test2);


        // 문제3.
        List<Trader> test3 = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(trader -> trader.getName()))
                .collect(Collectors.toList());

        System.out.println(test3);


        // 문제4.
        String test4 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce((s, s2) -> s +" "+ s2)
                .orElse(null);

        System.out.println(test4);


        // 문제5.
        boolean test5 = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        System.out.println(test5);

        System.out.println("-------------------------- 문제6 -----------------------------------");

        // 문제6.
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .forEach(System.out::println);


        // 문제7.
        int test7 = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max)
                .orElse(0);

        System.out.println(test7);


        // 문제8.
        int test8 = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::min)
                .orElse(0);

        System.out.println(test8);


        // 184 page.
        IntStream test = IntStream.rangeClosed(1,100)
                .filter(n -> n%2 == 0);

        System.out.println(test.count());*/



        // 185 page 피타고라스.
        /*IntStream.rangeClosed(1,100)
                    .boxed()
                    .flatMap(a -> IntStream.rangeClosed(a, 100)
                                    .mapToObj(b -> new double[]{a, b, Math.sqrt(a*a + b*b)})
                                    .filter(d -> d[2]%1 == 0))
                                    .forEach(doubles -> System.out.println(doubles[0] + " " + doubles[1] + " " + doubles[2]));*/


        // 191page 퀴즈 5-4.
        Stream.iterate(new int[]{0,1}, t -> new int[] {t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));


    }

}
