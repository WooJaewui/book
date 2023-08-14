package chapter1.item3;

public interface EnumInterface {

    String getHi();

    default String getHello() {
        return "hello";
    }

}
