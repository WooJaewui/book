package templateCallback;

public class ClientWithTemplateCallback {

    public static void main(String[] args) {

        Soldier soldier = new Soldier();

        soldier.runContext( "상황 1번에 맞는 콜백 실행!!");

        System.out.println("-------------------------------------------");

        soldier.runContext("상황 2번에 맞는 콜백 실행!!");

    }
}
