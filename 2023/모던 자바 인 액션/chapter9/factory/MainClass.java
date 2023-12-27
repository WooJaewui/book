package chapter9.factory;

import chapter9.factory.classic.ProductFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MainClass {

    public static void main(String[] args) {

        Product bond = ProductFactory.createProduct("bond");
        System.out.println("bond = " + bond);


        Product bond1 = chapter9.factory.lambda.ProductFactory.createProduct("bond");
        System.out.println("bond1 = " + bond1);

        Product hi = chapter9.factory.lambda.ProductFactory.createProduct("hi");
        System.out.println("hi = " + hi);

    }

}
