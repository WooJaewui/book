package chapter9.templatemethod;

import chapter9.templatemethod.classic.User;
import chapter9.templatemethod.lambda.OnlineBanking;

public class MainClass {

    public static void main(String[] args) {

        chapter9.templatemethod.classic.OnlineBanking onlineBanking1 = new chapter9.templatemethod.classic.OnlineBanking();
        onlineBanking1.processCustomer(10);


        OnlineBanking onlineBanking2 = new OnlineBanking();
        onlineBanking2.processCustomer(10, user -> { user.setAge(10); user.setName("hi");
            System.out.println("user = " + user);});

    }



}
