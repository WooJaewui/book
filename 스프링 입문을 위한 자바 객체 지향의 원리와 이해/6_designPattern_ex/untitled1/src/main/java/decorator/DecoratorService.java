package decorator;

public class DecoratorService implements DService{

    DService dService;

    @Override
    public String runSomething() {
        System.out.println("데코레이터 실행");
        dService = new NormalService();
        return "추가 서비스 + " + dService.runSomething();
    }
}
