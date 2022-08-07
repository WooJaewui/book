package strategy;

public class ClientWithStrategy {
    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.runContext(new StrategyGun());
        System.out.println("----------------------------");
        soldier.runContext(new StrategySword());
    }
}
