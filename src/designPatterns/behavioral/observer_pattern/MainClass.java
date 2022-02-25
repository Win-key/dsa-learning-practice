package designPatterns.behavioral.observer_pattern;

import designPatterns.behavioral.observer_pattern.observable.WeatherSystem;
import designPatterns.behavioral.observer_pattern.observer.SmartPhone;
import designPatterns.behavioral.observer_pattern.observer.SmartTV;

public class MainClass {

    public static void main(String[] args) {
        WeatherSystem weatherSystem = new WeatherSystem();
        SmartPhone smartPhone = new SmartPhone(weatherSystem);
        SmartTV smartTV = new SmartTV(weatherSystem);

        weatherSystem.add(smartPhone);
        weatherSystem.add(smartTV);

        weatherSystem.updateTemperature(97);

        /* Output:
            I display from smartTV. Temperature is 97
            I display from SmartPhone. Temperature is 97
        */
    }

}
