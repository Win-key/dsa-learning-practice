package designPatterns.creational.singleton;

import java.util.Objects;

/**
 * I have taken Earth as a single ton object.
 * There can be multiple planet that looks like the earth, but what we know is the Earth we live in.
 *
 * I thought, it would be a good example for monitoring  weather, earth quake, wildfire or tsunami
 * to get detail of everything that's happening in earth
 *
 *
 * Singleton basically a code smell and to use it, we need proper reason
 *  like a database object used across multiple clients
 *
 */

public class Earth {

    private static Earth earth;
    private Earth() { }

    public void getWeather() {
        int x = (int) (Math.random() * 3);
        switch (x) {
            case 0: System.out.println("Sunny"); break;
            case 1: System.out.println("Rainy"); break;
            case 2: System.out.println("Foggy"); break;
        }
    }

    public static Earth getInstance() {
        if(Objects.isNull(earth)) {
            synchronized (Earth.class) {
                System.out.println("Lazy initialization");
                // Just in case of a race condition where two clients successfully got into first null check
                if (Objects.isNull(earth))
                    earth = new Earth();
            }
        }
        return earth;
    }
}
