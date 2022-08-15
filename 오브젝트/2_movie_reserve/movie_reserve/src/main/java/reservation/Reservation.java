package reservation;

import util.Money;

public class Reservation {

    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Screening screening, Money fee, int audienceCount) {
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }

}
