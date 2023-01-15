package chapter9.observer.lambda;

@FunctionalInterface
public interface Observer {
    void notify(String tweet);
}
