package designPatterns.structural.bridge.implementation;

import GFG.sorting.Utils;

public class Radio implements CommunicationDevice {

    @Override
    public boolean switchOn() {
        Utils.print("Radio is switched on");
        return true;
    }

    @Override
    public boolean switchOff() {
        Utils.print("Radio is switched off");
        return true;
    }

    @Override
    public boolean volumeUp() {
        Utils.print("Radio volume is turned Up");
        return true;
    }

    @Override
    public boolean volumeDown() {
        Utils.print("Radio volume is turned down");
        return true;
    }

    @Override
    public boolean channelUp() {
        Utils.print("Radio channel is moved up");
        return true;
    }

    @Override
    public boolean channelDown() {
        Utils.print("Radio channel is moved down");
        return true;
    }

    @Override
    public boolean setChannel(float channel) {
        Utils.print("Radio channel is set to " + channel);
        return true;
    }

    @Override
    public boolean mute() {
        Utils.print("Radio volume is muted");
        return true;
    }
}
