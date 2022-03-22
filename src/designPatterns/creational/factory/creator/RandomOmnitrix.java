package designPatterns.creational.factory.creator;

import designPatterns.creational.factory.product.AlienForm;

public class RandomOmnitrix extends Omnitrix {

    @Override
    public AlienForm transform() {

        return this.selectAlien((int) (Math.random() * 4));
    }
}
