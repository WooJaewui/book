package chapter9.strategy.classic;

public class IsNumeric implements ValidationStrategy{
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
