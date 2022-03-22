package designPatterns.creational.abstract_factory.creator.interfaces;

import designPatterns.creational.abstract_factory.product.interfaces.Chair;
import designPatterns.creational.abstract_factory.product.interfaces.CoffeeTable;
import designPatterns.creational.abstract_factory.product.interfaces.Sofa;

public interface FurnitureFactory {
    Chair getChair();
    Sofa getSofa();
    CoffeeTable getCoffeeTable();
}
