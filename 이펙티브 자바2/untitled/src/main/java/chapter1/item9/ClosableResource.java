package chapter1.item9;

public class ClosableResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("리소스 닫기");
    }
}
