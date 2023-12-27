package chapter13.conflict;

public interface A {
    default void hell() {
        System.out.println("A");
    }
}
