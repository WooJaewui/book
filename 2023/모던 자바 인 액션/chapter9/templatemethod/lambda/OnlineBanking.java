package chapter9.templatemethod.lambda;

import java.util.function.Consumer;

public class OnlineBanking {

    public void processCustomer(int id, Consumer<User> makeUserHappy) {

        User user = new User();
        makeUserHappy.accept(user);

    }

}
