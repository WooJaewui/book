package chapter11.optional;

import java.util.Optional;
import java.util.Properties;

public class MainClass {

    public static void main(String[] args) {

        /*Person person = new Person();
        person.setCar(Optional.of(new Car()));
        person.getCar().get().setInsurance(Optional.of(new Insurance()));



        Optional<Person> optPerson = Optional.of(person);
        String s = optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");

        System.out.println("s = " + s);*/


        // 퀴즈 11-1 _ 381page.


        Properties properties = new Properties();

        System.out.println(readDuration2(properties, null));


    }

    public Insurance findCheapestInsurance(Person person, Car car) {
        return new Insurance();
    }


    public Optional<Insurance> nullSafeFindCheapestInsurance1 (Optional<Person> person, Optional<Car> car){
        if(person.isPresent() && car.isPresent()) {
            return Optional.of(findCheapestInsurance(person.get(), car.get()));
        }
        return Optional.empty();
    }

    public Optional<Insurance> nullSafeFindCheapestInsurance2 (Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c-> findCheapestInsurance(p, c)));
    }


    public int readDuration(Properties props, String name) {
        String value = props.getProperty(name);

        if(value != null) {
            try {
                int i = Integer.parseInt(value);
                if(i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) {


            }
        }
        return 0;
    }

    public static int readDuration2(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .map(Integer::parseInt)
                .filter(i -> i > 0)
                .orElse(0);
    }


}


class OptionalUtility {
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch(NumberFormatException e) {
            return Optional.empty();
        }
    }
}
