package designPatterns.structural.bridge.abstraction;

import designPatterns.structural.bridge.implementation.CommunicationDevice;

public class Remote {

    private final CommunicationDevice communicationDevice;

    public Remote(CommunicationDevice communicationDevice) {
        this.communicationDevice = communicationDevice;
    }

    protected CommunicationDevice getDevice() {
        return communicationDevice;
    }

    public boolean switchOn() {
        return communicationDevice.switchOn();
    }
    public boolean switchOff() {
        return communicationDevice.switchOff();
    }
    public boolean volumeUp() {
        return communicationDevice.volumeUp();
    }
    public boolean volumeDown() {
        return communicationDevice.volumeDown();
    }
    public boolean channelUp() {
        return communicationDevice.channelUp();
    }
    public boolean channelDown() {
        return communicationDevice.channelDown();
    }

}
