package designPatterns.creational.abstract_factory.product.concrete;

import designPatterns.creational.abstract_factory.product.interfaces.Sofa;

public class TraditionalSofa implements Sofa {

    @Override
    public void holdPeople() {
        System.out.println("I'm a traditional sofa");
    }

}
