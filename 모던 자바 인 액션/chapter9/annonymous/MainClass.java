package chapter9.annonymous;

public class MainClass {

    public static void main(String[] args) {




        int a = 10;
        /*Runnable r1 = () -> {
            int a = 2;
            System.out.println("a = " + a);
        };*/


        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println("a = " + a);
            }
        };

        r2.run();


        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("Danger!!");
            }
        });

        // doSomething(() -> System.out.println("hi"));

    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task a) {
        a.execute();
    }

}
