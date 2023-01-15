package chapter9.strategy.lambda;

import java.util.function.Predicate;

@FunctionalInterface
public interface ValidationStrategy<T extends String> {
    boolean test(T o);
}
