package discount;

import reservation.Screening;

public interface DiscountCondition {

    boolean isSatisFiedBy(Screening screening);

}
