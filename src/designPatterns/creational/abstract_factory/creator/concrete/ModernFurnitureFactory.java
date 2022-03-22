package designPatterns.creational.abstract_factory.creator.concrete;

import designPatterns.creational.abstract_factory.creator.interfaces.FurnitureFactory;
import designPatterns.creational.abstract_factory.product.concrete.ModernChair;
import designPatterns.creational.abstract_factory.product.concrete.ModernCoffeeTable;
import designPatterns.creational.abstract_factory.product.concrete.ModernSofa;
import designPatterns.creational.abstract_factory.product.interfaces.Chair;
import designPatterns.creational.abstract_factory.product.interfaces.CoffeeTable;
import designPatterns.creational.abstract_factory.product.interfaces.Sofa;

public class ModernFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair getChair() {
        return new ModernChair();
    }

    @Override
    public Sofa getSofa() {
        return new ModernSofa();
    }

    @Override
    public CoffeeTable getCoffeeTable() {
        return new ModernCoffeeTable();
    }
}
