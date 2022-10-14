package inheritance;

public class Child extends Parent {

    private int b;

    public Child(int b) {
        // super();
        this.b = b;
    }

    @Override
    public void print() {
        System.out.println("super a : " + super.a + "    this a : " + this.a );
    }

}
