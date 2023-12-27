package templateCallback;

public class Soldier {

    // 파라미터에 final을 사용하면 메서드 내부에서 재할당 불가.
    void runContext(final String some) {
        System.out.println("전략 패턴 시작 전");
        executeStrategy(some).runStrategy();
        System.out.println("전략 패턴 시작 후");
    }

    // 파라미터에 final을 사용하면 메서드 내부에서 재할당 불가.
    private Strategy executeStrategy(final String some) {
        return new Strategy() {
            @Override
            public void runStrategy() {
                System.out.println(some);
            }
        };
    }

}
