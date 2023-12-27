package adapter;

public class AdapterServiceA{
    ServiceA serviceA;

    public void runService() {
        serviceA.runServiceA();
    }

    public AdapterServiceA() {
        this.serviceA = new ServiceA();
    }
}
