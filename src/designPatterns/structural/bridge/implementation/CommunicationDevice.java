package designPatterns.structural.bridge.implementation;

public interface CommunicationDevice {

    boolean switchOn();
    boolean switchOff();
    boolean volumeUp();
    boolean volumeDown();
    boolean channelUp();
    boolean channelDown();
    boolean setChannel(float channel);
    boolean mute();

}
