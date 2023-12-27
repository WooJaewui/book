package templateMethod;

public class Dog implements Animal{

    @Override
    public void play() {
        System.out.println("강아지 메서드 실행!!");
    }

    @Override
    public void hookMetohd() {
        System.out.println("후크메서드 오버라이드 O !!");
    }
}
