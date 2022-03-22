package designPatterns.creational.abstract_factory.product.concrete;

import designPatterns.creational.abstract_factory.product.interfaces.CoffeeTable;

public class TraditionalCoffeeTable implements CoffeeTable {

    @Override
    public void holdCoffee() {
        System.out.println("I'm a traditional coffee table.");
    }
}
