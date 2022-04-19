package designPatterns.creational.singleton;

public class Client {

    public static void main(String[] args) {
        Earth earth = Earth.getInstance();
        earth.getWeather();

        Earth thanosEarth = Earth.getInstance();
        thanosEarth.getWeather();
    }

}
