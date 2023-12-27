package chapter17.RxJava;

import chapter17.first.TempInfo;
import io.reactivex.Observable;
import io.reactivex.Observer;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {
        Observable<TempInfo> observable = getTemperature("new york");
        observable.blockingSubscribe(new TempObserver());
    }

    public static Observable<TempInfo> getTemperature(String town) {
        return Observable.create(emitter -> {
            Observable.interval(1, TimeUnit.SECONDS)
                    .subscribe(i -> {
                        if(!emitter.isDisposed()) {
                            if(i >= 5) {
                                emitter.onComplete();
                            } else {
                                try {
                                    emitter.onNext(TempInfo.fetch(town));
                                } catch (Exception e) {
                                    emitter.onError(e);
                                }
                            }
                        }
                    });
        });
    }

}
