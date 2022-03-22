package designPatterns.creational.abstract_factory.creator.concrete;

import designPatterns.creational.abstract_factory.creator.interfaces.FurnitureFactory;
import designPatterns.creational.abstract_factory.product.concrete.TraditionalChair;
import designPatterns.creational.abstract_factory.product.concrete.TraditionalCoffeeTable;
import designPatterns.creational.abstract_factory.product.concrete.TraditionalSofa;
import designPatterns.creational.abstract_factory.product.interfaces.Chair;
import designPatterns.creational.abstract_factory.product.interfaces.CoffeeTable;
import designPatterns.creational.abstract_factory.product.interfaces.Sofa;

public class TraditionalFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair getChair() {
        return new TraditionalChair();
    }

    @Override
    public Sofa getSofa() {
        return new TraditionalSofa();
    }

    @Override
    public CoffeeTable getCoffeeTable() {
        return new TraditionalCoffeeTable();
    }
}
