package strategy;

public class StrategyGun implements Strategy{
    @Override
    public void runStrategy() {
        System.out.println("총 발사!!!");
    }
}
