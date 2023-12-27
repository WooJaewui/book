package discount;

import reservation.Screening;
import util.Money;

public interface DefaultDiscountPolicy2 {

    // 추상 클래스는 구현을 공유할 필요가 있을 때 사용한다. (64page)
    // [public static final]의 형태로 변수를 사용할 수 있다. => 바로 초기화해야 한다.

    /*List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy2(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }*/

    public int count = 10;


    // java 8 => default, static 기능 추가.
    // java 9 => private 기능 추가.
    default Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if(each.isSatisfiedBy(screening)) {
                inside();
                return getDisCountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    private void inside() {
        System.out.println("템플릿 시작!!!");
    }
    abstract default Money getDisCountAmount(Screening screening);



}
