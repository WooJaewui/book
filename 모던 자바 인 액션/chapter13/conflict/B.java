package chapter13.conflict;

public interface B {
    default void hell() {
        System.out.println("AAA");
    }
}
