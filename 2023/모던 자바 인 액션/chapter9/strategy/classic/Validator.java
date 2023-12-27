package chapter9.strategy.classic;

import chapter9.strategy.classic.ValidationStrategy;

public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

}
