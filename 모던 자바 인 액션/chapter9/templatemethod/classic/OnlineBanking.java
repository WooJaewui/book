package chapter9.templatemethod.classic;

public class OnlineBanking {

    public void processCustomer(int id) {

        User user = new User();
        makeUserHappy(user);

    }

    public void makeUserHappy(User user) {
        user.setAge(10);
        user.setName("Jame");
    }

}
