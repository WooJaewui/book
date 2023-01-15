package chapter9.strategy;

import chapter9.strategy.classic.IsNumeric;
import chapter9.strategy.classic.Validator;

public class MainClass {

    public static void main(String[] args) {

        Validator validator = new Validator(new IsNumeric());

        boolean result = validator.validate("431");

        System.out.println("result = " + result);

        chapter9.strategy.lambda.Validator validator1 = new chapter9.strategy.lambda.Validator((String s) -> s.matches("[a-z]+"));

        boolean result2 = validator1.validate("test");
        System.out.println("result2 = " + result2);

        boolean result3 = validator1.validate("123123");
        System.out.println("result3 = " + result3);

    }

}
