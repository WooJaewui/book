package chapter9.observer.classic;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
