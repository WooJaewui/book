package inheritance;

public class MainClass {


    public static void main(String[] args) {

        // 자식 인스턴스 생성.
        Child c = new Child(100);

        // super.a 변경.
        c.setA(300);

        // super.a 와 this.a 비교 출력.
        c.print();

    }

}
