package chapter11.nullcheck;

public class MainClass {

    public static void main(String[] args) {




    }

    public String getCarInsuranceName1(Person person) {

        if(person != null) {
            Car car = person.getCar();
            if(car != null) {
                Insurance insurance = car.getInsurance();
                if(insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }

    public String getCarInsuranceName2(Person person) {

        if(person == null) {
            return "Unknown";
        }

        Car car = person.getCar();
        if(car == null) {
            return "Unknown";
        }

        Insurance insurance = car.getInsurance();
        if(insurance == null) {
            return "Unkown";
        }

        return insurance.getName();
    }


}
