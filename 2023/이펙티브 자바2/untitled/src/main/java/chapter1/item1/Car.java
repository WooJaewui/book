package chapter1.item1;

public class Car {

    private String color;

    public Car() {
    }

    public Car(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    static Car getInstance() {
        return new Car();
    }

    static Car getRedCar() {
        return new RedCar();
    }

    // ride ...

}
