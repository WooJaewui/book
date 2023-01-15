package chapter9.observer;

import chapter9.observer.classic.*;
import chapter9.observer.lambda.Feed;

public class MainClass {
    public static void main(String[] args) {

        /*Feed feed = new Feed();

        feed.registerObserver(new Guardian());
        feed.registerObserver(new LeMonde());
        feed.registerObserver(new NYTimes());

        feed.notifyObservers("queen");
        feed.notifyObservers("wine");
        feed.notifyObservers("money");
        feed.notifyObservers("zero");*/

        Feed feed = new Feed();
        feed.registerObserver(tweet -> { if(tweet != null && tweet.contains("queen")) {
            System.out.println("Yet More news from London... " + tweet);
        } });

        feed.notifyObservers("quueenasdasdf");
        feed.notifyObservers("queen asdfasdfasdfsdaf");


    }

}
