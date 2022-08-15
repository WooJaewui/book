package discount;

import reservation.Screening;
import util.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy{

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if(each.isSatisFiedBy(screening)) {
                return getDisCountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract protected Money getDisCountAmount(Screening screening);

}
