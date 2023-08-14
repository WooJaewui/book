package chapter1.item3;

public class SingleTon2 {

    private static SingleTon2 INSTANCE = null;

    private SingleTon2() {
    }

    public static SingleTon2 getInstance() {
        synchronized (SingleTon2.class) {
            if (INSTANCE == null) {
                INSTANCE = new SingleTon2();
            }
        }
        return INSTANCE;
    }
}



