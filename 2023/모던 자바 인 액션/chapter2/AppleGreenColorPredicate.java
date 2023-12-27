package chapter2;

public class AppleGreenColorPredicate implements ApplePredicate{

    Color GREEN = Color.GREEN;

    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }

}
