package chapter10.dsl.lambdadsl;

import chapter10.dsl.domain.Trade;

import java.lang.reflect.Method;

public class TradeBuilder {

    private final MethodChainingOrderBuilder builder;
    public final Trade trade = new Trade();

    public TradeBuilder(MethodChainingOrderBuilder builder, Trade.Type type, int quantity) {
        this.builder = builder;
        trade.setType(type);
        trade.setQuantity(quantity);
    }

    public StockBuilder stock(String symbol) {
        return new StockBuilder(builder, trade, symbol);
    }


}
