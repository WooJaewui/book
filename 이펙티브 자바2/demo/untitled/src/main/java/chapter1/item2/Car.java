package chapter1.item2;

public class Car {

    private final String color;
    private final String size;

    private Car(Builder builder) {
        this.color = builder.color;
        this.size = builder.size;
    }

    public static class Builder {

        private String color = null;
        private String size = null;

        public Builder color(String colorValue) {
            color = colorValue;
            return this;
        }

        public Builder size(String sizeValue) {
            size = sizeValue;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }

    @Override
    public String toString() {
        return "color = " + color + ", size = " + size;
    }
}
