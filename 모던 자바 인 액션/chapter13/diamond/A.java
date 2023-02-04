package chapter13.diamond;

public interface A {
    default void hell() {
        System.out.println("A");
    }
}
