package chapter10.dsl.domain;

public class Trade {

    public enum Type { BUY, SELL}
    private Type type;

    private Stock stock;
    private int quantity;
    private double price;

    public void setType(Type type) {
        this.type = type;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getValue() {
        return quantity * price;
    }


}
