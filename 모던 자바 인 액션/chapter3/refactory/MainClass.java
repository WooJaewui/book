package chapter3.refactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class MainClass {

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();

        inventory.sort(new AppleComparator());

        inventory.sort((a1,a2)-> a1.getWeight().compareTo(a2.getWeight()));

        inventory.sort(comparing(Apple::getWeight));



    }

}
