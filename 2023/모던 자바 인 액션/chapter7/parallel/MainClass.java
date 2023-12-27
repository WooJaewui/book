package chapter7.parallel;

import chapter7.benchmark.ParallelStreamBenchmark;

import java.util.stream.LongStream;

public class MainClass {

    public static void main(String[] args) {

        System.out.println(sideEffectParallelSum(200L));

    }

    public static long sideEffectParallelSum(long n) {
        Accumulator a = new Accumulator();
        LongStream.rangeClosed(1, n)
                .parallel()
                .forEach(a::add);
        return a.total;

    }

}

class Accumulator {
    public long total = 0;
    public void add(long value) {
        total += value;
    }
}
