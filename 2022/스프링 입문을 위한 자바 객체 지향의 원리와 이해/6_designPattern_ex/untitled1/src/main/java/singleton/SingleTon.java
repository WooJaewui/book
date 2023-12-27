package singleton;

public class SingleTon {
    static private SingleTon INSTANCE;

    private SingleTon() {

    }

    public static SingleTon getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new SingleTon();
        }
        return INSTANCE;
    }

}
