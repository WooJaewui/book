package chapter1.item3;

public class SingleTon {

    private static SingleTon INSTANCE = null;

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        synchronized (SingleTon.class) {
            if (INSTANCE == null) {
                INSTANCE = new SingleTon();
            }
        }
        return INSTANCE;
    }

}
