package designPatterns.creational.abstract_factory.product.concrete;

import designPatterns.creational.abstract_factory.product.interfaces.Sofa;

public class ModernSofa implements Sofa {
    @Override
    public void holdPeople() {
        System.out.println("I'm a modern sofa....");
    }
}
