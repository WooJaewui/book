package chapter1.item9;

public class MainClass {

    public static void main(String[] args) {
        try (ClosableResource closableResource = new ClosableResource()) {
            System.out.println("실행");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
