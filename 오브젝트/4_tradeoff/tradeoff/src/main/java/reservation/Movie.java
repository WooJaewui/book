package reservation;

import discount.DiscountCondition;
import util.Money;
import util.MovieType;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Movie {

    private String title;
    private Duration ruuningTime;
    private Money fee;
    private List<DiscountCondition> discountConfitions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DiscountCondition> getDiscountConfitions() {
        return Collections.unmodifiableList(discountConfitions);
    }

    public void setDiscountConfitions(List<DiscountCondition> discountConfitions) {
        this.discountConfitions = discountConfitions;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
}
