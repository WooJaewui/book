package templateMethod;

public interface Animal {

    default void playWtihOwner() {
        System.out.println("메소드 실행 전 템플릿");
        play();
        hookMetohd();
        System.out.println("메소드 실행 후 템플릿");

    }

    void play();

    default void hookMetohd(){
        System.out.println("후크 메소드 - 오버라이드 필수 X");
    };
}
