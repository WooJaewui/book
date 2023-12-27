package chapter1.item3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MainClass {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        // 싱글톤1
        SingleTon2 instance1 = SingleTon2.getInstance();
        SingleTon2 instance2 = SingleTon2.getInstance();

        System.out.println(System.identityHashCode(instance1));
        System.out.println(System.identityHashCode(instance2));
        
        
        // 리플렉션으로 싱글톤1 깨기
        Class elvis1 = SingleTon2.class;
        Constructor[] constructors = elvis1.getDeclaredConstructors();


        //싱글톤1
        for (Constructor con : constructors) {
            System.out.println(con);
            con.setAccessible(true);

            SingleTon2 instance3 = (SingleTon2)con.newInstance(null);
            System.out.println(System.identityHashCode(instance3));

            SingleTon2 instance4 = (SingleTon2)con.newInstance(null);
            System.out.println(System.identityHashCode(instance4));
        }


        // 싱글톤2
        SingleTon1 instance5 = SingleTon1.INSTANCE;
        SingleTon1 instance6 = SingleTon1.INSTANCE;

        System.out.println(System.identityHashCode(instance5));
        System.out.println(System.identityHashCode(instance6));

        // 리플렉션으로 싱글톤2 깨기
        Class singleTon2Class = SingleTon1.class;
        Constructor[] constructors2 = singleTon2Class.getDeclaredConstructors();

        //싱글톤1
        for (Constructor con : constructors2) {
            System.out.println(con);
            con.setAccessible(true);

            SingleTon1 instance7 = (SingleTon1)con.newInstance(null);
            System.out.println(System.identityHashCode(instance7));

            SingleTon1 instance8 = (SingleTon1)con.newInstance(null);
            System.out.println(System.identityHashCode(instance8));
        }


        System.out.println(EnumClass.MON.getHello());
        System.out.println(EnumClass.MON.getHi());


        // 리플렉션으로 싱글톤3 깨기
        Class singleTon3Class = SingleTon3.class;
        Constructor[] constructors3 = singleTon3Class.getDeclaredConstructors();

        //싱글톤1
        for (Constructor con : constructors3) {
            System.out.println(con);
            con.setAccessible(true);

            SingleTon3 instance7 = (SingleTon3)con.newInstance();
            System.out.println(System.identityHashCode(instance7));

            SingleTon3 instance8 = (SingleTon3)con.newInstance();
            System.out.println(System.identityHashCode(instance8));
        }

    }
}
