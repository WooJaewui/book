package chapter9.observer.lambda;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject{

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(String s) {
        observers.forEach(observer -> observer.notify(s));
    }
}
