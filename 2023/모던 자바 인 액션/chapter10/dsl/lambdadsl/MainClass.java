package chapter10.dsl.lambdadsl;

import chapter10.dsl.domain.Order;

public class MainClass {

    public static void main(String[] args) {

        Order order = MethodChainingOrderBuilder.forCustomer("BigBank")
                .buy(80)
                .stock("IBM")
                .on("NYSE")
                .at(125.00)
                .sell(50)
                .stock("GOOGLE")
                .on("NASDAQ")
                .at(375.00)
                .end();

    }


}
