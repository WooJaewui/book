package discount;

import reservation.Screening;
import util.Money;

public class PercentDiscountPolicy extends DiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDisCountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
