package chapter13.conflict;

public interface AA extends A{
    default void hell() {
        System.out.println("AA");
    }
}
