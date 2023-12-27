package reservation;

import util.Customer;
import util.Money;

public class Reservation {

    private Customer customer;
    private Screening screeming;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screeming, Money fee, int audienceCount) {
        this.customer = customer;
        this.screeming = screeming;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Screening getScreeming() {
        return screeming;
    }

    public void setScreeming(Screening screeming) {
        this.screeming = screeming;
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public int getAudienceCount() {
        return audienceCount;
    }

    public void setAudienceCount(int audienceCount) {
        this.audienceCount = audienceCount;
    }
}



