package chapter1.item9;

public class MainClass {

    public static void main(String[] args) throws Exception {

        ClosableResource closableResource1 = new ClosableResource();

        try {
            System.out.println("실행");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closableResource1.close();
        }


        try (ClosableResource closableResource2 = new ClosableResource()) {
            System.out.println("실행");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
