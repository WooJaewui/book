package chapter3.refactory;

import chapter2.Color;

public class Apple {

    Integer weight;
    Color color;

    public Integer getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
