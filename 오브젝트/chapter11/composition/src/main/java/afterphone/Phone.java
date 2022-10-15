package afterphone;


import java.util.ArrayList;
import java.util.List;

public abstract class Phone {

    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();


    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }

    public List<Call> getCalls() {
        return calls;
    }

}
