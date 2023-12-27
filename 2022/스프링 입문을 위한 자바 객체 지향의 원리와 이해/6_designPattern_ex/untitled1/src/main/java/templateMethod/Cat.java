package templateMethod;

public class Cat implements Animal{

    @Override
    public void play() {
        System.out.println("고양이 메서드 실행!! - 후크 메소드 오버라이드 하지 않음");
    }
    
}
