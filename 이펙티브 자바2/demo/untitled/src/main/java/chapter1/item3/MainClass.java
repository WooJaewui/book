package chapter1.item3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MainClass {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        // 싱글톤1
        SingleTon instance1 = SingleTon.getInstance();
        SingleTon instance2 = SingleTon.getInstance();

        System.out.println(System.identityHashCode(instance1));
        System.out.println(System.identityHashCode(instance2));
        
        
        // 리플렉션으로 싱글톤1 깨기
        Class elvis1 = SingleTon.class;
        Constructor[] constructors = elvis1.getDeclaredConstructors();


        //싱글톤1
        for (Constructor con : constructors) {
            System.out.println(con);
            con.setAccessible(true);

            SingleTon instance3 = (SingleTon)con.newInstance(null);
            System.out.println(System.identityHashCode(instance3));

            SingleTon instance4 = (SingleTon)con.newInstance(null);
            System.out.println(System.identityHashCode(instance4));
        }


        // 싱글톤2
        SingleTon2 instance5 = SingleTon2.INSTANCE;
        SingleTon2 instance6 = SingleTon2.INSTANCE;

        System.out.println(System.identityHashCode(instance5));
        System.out.println(System.identityHashCode(instance6));

        // 리플렉션으로 싱글톤2 깨기
        Class singleTon2Class = SingleTon2.class;
        Constructor[] constructors2 = singleTon2Class.getDeclaredConstructors();

        //싱글톤1
        for (Constructor con : constructors2) {
            System.out.println(con);
            con.setAccessible(true);

            SingleTon2 instance7 = (SingleTon2)con.newInstance(null);
            System.out.println(System.identityHashCode(instance7));

            SingleTon2 instance8 = (SingleTon2)con.newInstance(null);
            System.out.println(System.identityHashCode(instance8));
        }


        System.out.println(EnumClass.MON.getHello());
        System.out.println(EnumClass.MON.getHi());

    }
}
