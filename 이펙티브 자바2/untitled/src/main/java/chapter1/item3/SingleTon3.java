package chapter1.item3;

public class SingleTon3 {

    private static volatile SingleTon3 instance;

    private SingleTon3() throws Exception {
        if (instance != null) {
            throw new Exception();
        }
    }

    public static SingleTon3 getInstance() throws Exception {
        if (instance == null) {
            synchronized (SingleTon3.class) {
                if (instance == null) {
                    instance = new SingleTon3();
                }
            }
        }
        return instance;
    }
}



