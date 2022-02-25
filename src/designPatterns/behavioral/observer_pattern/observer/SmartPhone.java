package designPatterns.behavioral.observer_pattern.observer;

import designPatterns.behavioral.observer_pattern.observable.WeatherSystem;

public class SmartPhone implements IObserver, IDisplay{

    private final WeatherSystem weatherSystem;

    public SmartPhone(WeatherSystem weatherSystem) {
        this.weatherSystem = weatherSystem;
    }

    // this is called by observable.notifyClient()
    // Now observer understands that there is change of data in the observable weather system
    @Override
    public void update() {
        display(weatherSystem.getTemperature());
    }

    @Override
    public void display(Object data) {
        System.out.println("I display from SmartPhone. Temperature is " + data);
    }
}
