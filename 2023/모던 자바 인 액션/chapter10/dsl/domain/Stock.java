package chapter10.dsl.domain;

public class Stock {

    private String symbol;
    private String market;

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getMarket() {
        return market;
    }
}
