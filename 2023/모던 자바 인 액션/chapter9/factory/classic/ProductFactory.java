package chapter9.factory.classic;

import chapter9.factory.Loan;
import chapter9.factory.Product;
import chapter9.factory.Stock;
import chapter9.factory.Bond;

public class ProductFactory {

    public static Product createProduct(String name) {
        switch (name) {
            case "loan" :
                return new Loan();
            case "stock" :
                return new Stock();
            case "bond" :
                return new Bond();
            default :
                throw new RuntimeException("No such product " + name);
        }
    }

}
