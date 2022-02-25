package designPatterns.behavioral.observer_pattern.observable;

import designPatterns.behavioral.observer_pattern.observer.IObserver;

import java.util.HashSet;
import java.util.Set;

public class WeatherSystem implements IObservable {


    private int temperature;
    private Set<IObserver> clients = new HashSet<>();

    @Override
    public void add(IObserver client) {
        clients.add(client);
    }

    @Override
    public void remove(IObserver client) {
        clients.remove(client);
    }

    @Override
    public void notifyClient() {
        this.clients.forEach(IObserver::update);
    }

    public void updateTemperature(int temp) {
        this.temperature = temp;
        // this notify needs to be called with in the observable
        this.notifyClient();
    }

    public int getTemperature() {
        return this.temperature;
    }
}
