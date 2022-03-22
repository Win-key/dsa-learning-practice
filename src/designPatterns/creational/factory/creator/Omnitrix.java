package designPatterns.creational.factory.creator;

import designPatterns.creational.factory.product.AlienForm;
import designPatterns.creational.factory.product.DiamondHead;
import designPatterns.creational.factory.product.FourArms;
import designPatterns.creational.factory.product.GhostFreak;
import designPatterns.creational.factory.product.GrayMatter;

// Does make sense when we say factory with respect to Ben 10 series.
// May AlienFactory is the good naming.
//
public abstract class Omnitrix {
    public abstract AlienForm transform();

    AlienForm selectAlien(int code) {
        switch (code) {
            case 0: return new GrayMatter();
            case 1: return new DiamondHead();
            case 2: return new GhostFreak();
            case 3: return new FourArms();
            default:
                throw new IllegalArgumentException("Alien code not found");
        }
    }
}
