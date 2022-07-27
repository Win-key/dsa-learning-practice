package designPatterns.structural.bridge.abstraction;

import designPatterns.structural.bridge.implementation.CommunicationDevice;

public class AdvancedRemote extends Remote {

    public AdvancedRemote(CommunicationDevice communicationDevice) {
        super(communicationDevice);
    }

    public boolean setChannel(float channel) {
        return getDevice().setChannel(channel);
    }
    public boolean mute() {
        return getDevice().mute();
    }
}
