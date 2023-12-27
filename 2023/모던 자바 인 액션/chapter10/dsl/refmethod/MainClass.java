package chapter10.dsl.refmethod;


import chapter10.dsl.domain.Order;
import chapter10.dsl.domain.Trade;

public class MainClass {

    public static void main(String[] args) {

        Order order = new Order();

        Trade trade = new Trade();
        trade.setPrice(1000);
        trade.setQuantity(20);

        order.addTrade(trade);



        double value = new TaxCalculator().withTaxGeneral()
                .withTaxRegional()
                .withTaxSurcharge()
                .calculate(order);

        System.out.println("value = " + value);

    }

}
