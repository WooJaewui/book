package chapter13.diamond;

public interface C extends A {
    default void hell() {
        System.out.println("C");
    }
}
