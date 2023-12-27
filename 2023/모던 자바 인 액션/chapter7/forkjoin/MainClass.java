package chapter7.forkjoin;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
public class MainClass {

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(MainClass.class.getSimpleName())
                .warmupIterations(10)
                .measurementIterations(10)
                .forks(1)
                .build();

        new Runner(opt).run();

    }

    @Benchmark
    public static long forkJoinSum() {
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);

        return new ForkJoinPool().invoke(task);
    }

}
