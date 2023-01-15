package chapter9.factory.lambda;

import chapter9.factory.Bond;
import chapter9.factory.Loan;
import chapter9.factory.Product;
import chapter9.factory.Stock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProductFactory {

    static final Map<String, Supplier<Product>> map
            = Map.ofEntries(Map.entry("load", Loan::new), Map.entry("bond", Bond::new), Map.entry("Stock", Stock::new));


    public static Product createProduct(String name) {
        Supplier<Product> p = map.get(name);
        if(p != null) {
            return p.get();
        }

        throw new IllegalArgumentException("No such product " + name);
    }

}
