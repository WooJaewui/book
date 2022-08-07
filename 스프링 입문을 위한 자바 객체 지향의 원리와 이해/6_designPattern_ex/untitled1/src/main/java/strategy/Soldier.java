package strategy;

public class Soldier {

    void runContext(Strategy strategy) {
        System.out.println("전략 패턴 시작 전");
        strategy.runStrategy();
        System.out.println("전략 패턴 시작 후");
    }

}
