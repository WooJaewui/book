package discount;

import reservation.Screening;
import util.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);

}
