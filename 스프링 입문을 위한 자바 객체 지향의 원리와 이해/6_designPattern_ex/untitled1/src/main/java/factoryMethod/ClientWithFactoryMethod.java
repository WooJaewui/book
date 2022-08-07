package factoryMethod;

public class ClientWithFactoryMethod {
    public static void main(String[] args) {

        Animal dog = new Dog();
        AnimalToy animalToy = dog.getToy();

        animalToy.identify();
    }
}
