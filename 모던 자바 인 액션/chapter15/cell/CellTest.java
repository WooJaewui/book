package chapter15.cell;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class CellTest {

    public static void main(String[] args) {

        SimpleCell c3 = new SimpleCell("C3");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c1 = new SimpleCell("C1");

        c1.subscribe(c3);

        c1.onNext(10);
        c2.onNext(20);

    }

    public static class SimpleCell implements Flow.Publisher<Integer>, Flow.Subscriber<Integer> {

        private int value = 0;
        private String name;
        private List<Flow.Subscriber> subscribers = new ArrayList<>();

        public SimpleCell(String name) {
            this.name = name;
        }

        @Override
        public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
            subscribers.add(subscriber);
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {

        }

        @Override
        public void onNext(Integer newValue) {
            this.value = newValue;
            System.out.println(this.name + " : " + this.value);
            notifyAllSubscribes();
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onComplete() {

        }

        private void notifyAllSubscribes(){
            subscribers.forEach(subscriber -> subscriber.onNext(this.value));
        }
    }

}
