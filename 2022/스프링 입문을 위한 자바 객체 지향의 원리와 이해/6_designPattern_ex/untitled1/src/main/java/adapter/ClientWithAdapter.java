package adapter;

public class ClientWithAdapter {
    public static void main(String[] args) {

        // 기존 클래스의 정의된 메서드 명이 아닌 클라이언트가 사용하고 싶은 메서드 이름으로 바꿔서 사용.
        AdapterServiceA adapterServiceA = new AdapterServiceA();
        AdapterServiceB adapterServiceB = new AdapterServiceB();

        adapterServiceA.runService();
        adapterServiceB.runService();

    }
}
