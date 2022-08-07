package templateMethod;

public class ClientWithTemplateMethod {
    public static void main(String[] args) {

        Animal animal = new Cat();

        animal.playWtihOwner();

        System.out.println("----------------------------------------------");

        animal = new Dog();

        animal.playWtihOwner();


    }
}
