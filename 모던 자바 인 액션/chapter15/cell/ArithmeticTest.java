package chapter15.cell;

public class ArithmeticTest {

    public static void main(String[] args) {

        ArithmeticCell c3 = new ArithmeticCell("C3");
        CellTest.SimpleCell c2 = new CellTest.SimpleCell("C2");
        CellTest.SimpleCell c1 = new CellTest.SimpleCell("C1");

        /*c1.subscribe(c3::setLeft);
        c1.subscribe(c3::setRight);*/

        c1.onNext(10);
        c1.onNext(20);
        c1.onNext(15);




    }

}
