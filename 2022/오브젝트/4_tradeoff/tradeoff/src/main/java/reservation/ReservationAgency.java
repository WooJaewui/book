package reservation;

import discount.DiscountCondition;
import util.Customer;
import util.DiscountConditionType;
import util.Money;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discounrtable = false;

        for(DiscountCondition condition : movie.getDiscountConfitions()) {

            if(condition.getType() == DiscountConditionType.PERIOD) {
                discounrtable = screening.getWhenScreened().equals(condition.getDayOfWeek()) &&
                        condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                        condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
            } else {
                discounrtable = condition.getSequnce() == screening.getSequence();
            }

            if(discounrtable) {
                break;
            }
        }

        Money fee;

        if(discounrtable) {
            Money discountAmount = Money.ZERO;

            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NONE_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
            }

            fee = movie.getFee().minus(discountAmount);
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }

}
