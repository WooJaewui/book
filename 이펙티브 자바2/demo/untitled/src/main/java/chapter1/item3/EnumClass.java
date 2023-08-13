package chapter1.item3;

public enum EnumClass implements EnumInterface {
    SUN("월"), MON("화"), TUE("수");
    private final String symbol;

    EnumClass(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getHi() {
        return "hi";
    }
}
