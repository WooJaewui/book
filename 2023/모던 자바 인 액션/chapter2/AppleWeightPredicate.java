package chapter2;

public class AppleWeightPredicate implements AppleWeightFilter {


    @Override
    public int test(Apple apple) {
        if(apple.getWeight() > 100) {
            return 1;
        } else {
            return 0;
        }
    }
}
