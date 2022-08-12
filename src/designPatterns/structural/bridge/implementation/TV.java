package designPatterns.structural.bridge.implementation;

import utils.Utils;

public class TV implements CommunicationDevice {

    @Override
    public boolean switchOn() {
        Utils.print("TV is switched on");
        return true;
    }

    @Override
    public boolean switchOff() {
        Utils.print("TV is switched off");
        return true;
    }

    @Override
    public boolean volumeUp() {
        Utils.print("TV volume is turned Up");
        return true;
    }

    @Override
    public boolean volumeDown() {
        Utils.print("TV volume is turned down");
        return true;
    }

    @Override
    public boolean channelUp() {
        Utils.print("TV channel is moved up");
        return true;
    }

    @Override
    public boolean channelDown() {
        Utils.print("TV channel is moved down");
        return true;
    }

    @Override
    public boolean setChannel(float channel) {
        Utils.print("TV channel is set to " + channel);
        return true;
    }

    @Override
    public boolean mute() {
        Utils.print("TV volume is muted");
        return true;
    }
}
