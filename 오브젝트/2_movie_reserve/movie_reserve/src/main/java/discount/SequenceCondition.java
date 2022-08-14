package discount;

import reservation.Screening;

public class SequenceCondition implements DiscountCondition {

    private int sequnce;

    public SequenceCondition(int sequnce) {
        this.sequnce = sequnce;
    }

    @Override
    public boolean isSatisFiedBy(Screening screening) {
        return screening.isSeqeunce(sequnce);
    }

}
