package proxy;

public class Service implements IService {
    @Override
    public String runSomthing() {
        return "서비스 테스트!!";
    }
}
