package designPatterns.creational.abstract_factory.product.concrete;

import designPatterns.creational.abstract_factory.product.interfaces.Chair;

public class TraditionalChair implements Chair {

    @Override
    public void holdPerson() {
        System.out.println("I'm a traditional chair.");
    }
}
