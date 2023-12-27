package chapter2;

public class AppleWeightCheck implements AppleWeightFilter{

    @Override
    public int test(Apple apple) {
        return apple.getWeight();
    }
}
