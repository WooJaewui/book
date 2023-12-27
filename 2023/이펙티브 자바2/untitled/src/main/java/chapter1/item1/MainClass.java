package chapter1.item1;

public class MainClass {

    public static void main(String[] args) {

        Car instance = Car.getInstance();
        Car redCar1 = Car.getRedCar();
        RedCar redCar2 = (RedCar) Car.getRedCar();

        System.out.println(instance.getColor());
        System.out.println(redCar1.getColor());
        System.out.println(redCar2.getColor());
    }
}
