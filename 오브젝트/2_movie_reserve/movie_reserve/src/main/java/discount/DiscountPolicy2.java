package discount;

import reservation.Screening;
import util.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface DiscountPolicy2 {

    // [public static final]의 형태로 변수를 사용할 수 있다. => 바로 초기화해야 한다.
    /*List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy2(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }*/

    public int count = 10;


    default Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if(each.isSatisfiedBy(screening)) {
                inside();
                return getDisCountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    default void inside() {
        System.out.println("hi");
    }
    abstract protected Money getDisCountAmount(Screening screening);


}
