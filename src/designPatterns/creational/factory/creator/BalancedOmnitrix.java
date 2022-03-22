package designPatterns.creational.factory.creator;

import designPatterns.creational.factory.product.AlienForm;

public class BalancedOmnitrix extends Omnitrix {

    private int state = 0;

    @Override
    public AlienForm transform() {
        return this.selectAlien((state++)%4);
    }
}
