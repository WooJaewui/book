package discount;

import reservation.Screening;
import util.Money;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        inside();
        for(DiscountCondition each : conditions) {
            if(each.isSatisFiedBy(screening)) {

                return getDisCountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    private final void inside() {
        System.out.println("template start!!");
    }

    abstract protected Money getDisCountAmount(Screening screening);

}
