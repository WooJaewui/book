package chapter10.dsl.nestedfunction;

import chapter10.dsl.domain.Order;
import static chapter10.dsl.nestedfunction.NestedFunctionOrderBuilder.*;

public class MainClass {

    public static void main(String[] args) {

        Order order = order("BigBank",
                buy(80, stock("IBM", on("NYSE")), at(125.00)),
                sell(50, stock("GOOGLE", on("NASDAQ")), at(375.00))
        );

    }

}
