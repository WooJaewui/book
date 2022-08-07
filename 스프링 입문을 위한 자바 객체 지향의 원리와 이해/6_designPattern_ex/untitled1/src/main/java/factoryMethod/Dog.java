package factoryMethod;

public class Dog implements Animal{
    @Override
    public AnimalToy getToy() {
        return new DogToy();
    }
}
