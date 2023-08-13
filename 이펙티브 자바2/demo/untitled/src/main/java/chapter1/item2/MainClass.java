package chapter1.item2;

public class MainClass {

    public static void main(String[] args) {

        /*Car car1 = new Car.Builder().build();
        System.out.println(car1);


        Car car2 = new Car.Builder().color("red").color("blue").build();
        System.out.println(car2);*/


        // OutOfMemory Test
        /*List<Object> al = new ArrayList<>();



        for (int i=0; i < 50; i++) {
            al.add(new Outer_Class(100000000).getInnerObject());
            System.out.println(i);
        }*/


        //static 클래스 확인
        System.out.println("확인");

        Outer_Class outer_class = new Outer_Class(20);

        //Outer_Class.Inner_Class inner_class = new Outer_Class.Inner_Class();
    }

}
