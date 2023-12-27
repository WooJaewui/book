package chapter10.dsl.sequencefunction;

import chapter10.dsl.domain.Stock;

public class StockBuilder {

    public Stock stock = new Stock();

    public void symbol(String symbol) {
        stock.setSymbol(symbol);
    }

    public void market(String market) {
        stock.setMarket(market);
    }

}
