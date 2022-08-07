package proxy;

public class ProxyService implements IService {

    IService service;
    @Override
    public String runSomthing() {
        System.out.println("프록시 서비스 실행!!");
        service = new Service();
        return service.runSomthing();
    }
}
