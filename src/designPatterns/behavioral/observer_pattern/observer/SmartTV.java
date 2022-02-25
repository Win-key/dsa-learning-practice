package designPatterns.behavioral.observer_pattern.observer;

import designPatterns.behavioral.observer_pattern.observable.WeatherSystem;

public class SmartTV implements IObserver, IDisplay {

    private final WeatherSystem weatherSystem;

    public SmartTV(WeatherSystem weatherSystem) {
        this.weatherSystem = weatherSystem;
    }

    @Override
    public void display(Object data) {
        System.out.println("I display from smartTV. Temperature is " + data);
    }

    @Override
    public void update() {
        display(weatherSystem.getTemperature());
    }
}
