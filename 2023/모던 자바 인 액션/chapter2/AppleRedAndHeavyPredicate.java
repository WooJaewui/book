package chapter2;

public class AppleRedAndHeavyPredicate implements ApplePredicate {

    Color RED = Color.RED;

    @Override
    public boolean test(Apple apple) {
        return RED.equals(apple.getColor()) && apple.getWeight() > 150;
    }

}
