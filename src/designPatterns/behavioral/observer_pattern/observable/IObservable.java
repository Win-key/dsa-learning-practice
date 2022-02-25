package designPatterns.behavioral.observer_pattern.observable;

import designPatterns.behavioral.observer_pattern.observer.IObserver;

public interface IObservable {

    void add(IObserver client);
    void remove(IObserver client);
    void notifyClient();

}
