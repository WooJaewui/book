package proxy;

public class ClientWithProxy {
    public static void main(String[] args) {
        IService service = new ProxyService();
        System.out.println(service.runSomthing());
    }
}
