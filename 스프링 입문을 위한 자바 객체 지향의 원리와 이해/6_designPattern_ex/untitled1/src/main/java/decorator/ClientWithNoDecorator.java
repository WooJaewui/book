package decorator;

public class ClientWithNoDecorator {
    public static void main(String[] args) {
        NormalService normalService = new NormalService();
        System.out.println(normalService.runSomething());
    }
}
