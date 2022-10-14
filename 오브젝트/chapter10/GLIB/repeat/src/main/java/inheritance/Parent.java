package inheritance;

public class Parent {
    public int a;

    public Parent() {
        a = 1;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void print() {
        // override용.
    }

}
