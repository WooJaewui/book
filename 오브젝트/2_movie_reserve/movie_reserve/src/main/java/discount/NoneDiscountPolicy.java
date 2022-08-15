package discount;

import reservation.Screening;
import util.Money;

public class NoneDiscountPolicy extends DefaultDiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }

    @Override
    protected Money getDisCountAmount(Screening screening) {
        return Money.ZERO;
    }

}
