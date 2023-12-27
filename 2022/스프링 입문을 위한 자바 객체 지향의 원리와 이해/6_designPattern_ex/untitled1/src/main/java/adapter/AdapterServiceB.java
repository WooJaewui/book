package adapter;

public class AdapterServiceB {
    ServiceB serviceB;

    public void runService() {
        serviceB.runServiceB();
    }

    public AdapterServiceB() {
        this.serviceB = new ServiceB();
    }
}
