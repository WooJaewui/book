package chapter9.observer.lambda;

public interface Subject {
    public void registerObserver(Observer o);
    public void notifyObservers(String s);
}
