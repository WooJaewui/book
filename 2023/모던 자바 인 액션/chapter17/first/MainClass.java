package chapter17.first;

import java.util.concurrent.Flow.*;

public class MainClass {

    public static void main(String[] args) {
        getTemperatures("New York").subscribe(new TempSubscriber());
    }

    private static Publisher<TempInfo> getTemperatures(String town) {
        return subscriber -> subscriber.onSubscribe(new TempSubscription2(subscriber, town));
    }

    public static Publisher<TempInfo> getCelsiusTemperatures(String town) {
        return subscriber -> {
            TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempSubscription2(processor, town));
        };
    }

}
