package designPatterns.structural.bridge;

import designPatterns.structural.bridge.abstraction.AdvancedRemote;
import designPatterns.structural.bridge.abstraction.Remote;
import designPatterns.structural.bridge.implementation.Radio;
import designPatterns.structural.bridge.implementation.TV;

public class MainClass {

    public static void main(String[] args) {
        Remote remote = new Remote(new Radio());
        remote.switchOn();
        remote.channelUp();
        remote.volumeDown();
        remote.switchOff();

        AdvancedRemote remote2 = new AdvancedRemote(new TV());
        remote2.switchOn();
        remote2.channelUp();
        remote2.volumeDown();
        remote2.switchOff();
    }

}
