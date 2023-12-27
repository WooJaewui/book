package decorator;

public class ClientWithDecorator {
    public static void main(String[] args) {
        DService dService = new DecoratorService();
        System.out.println(dService.runSomething());
    }
}
