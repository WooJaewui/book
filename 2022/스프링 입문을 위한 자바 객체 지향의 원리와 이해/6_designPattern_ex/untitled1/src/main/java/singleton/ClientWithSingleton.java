package singleton;

public class ClientWithSingleton {

    public static void main(String[] args) {

        SingleTon singleTon1 = SingleTon.getInstance();
        SingleTon singleTon2 = SingleTon.getInstance();
        SingleTon singleTon3 = SingleTon.getInstance();

        System.out.println(singleTon1);
        System.out.println(singleTon2);
        System.out.println(singleTon3);

    }
}
