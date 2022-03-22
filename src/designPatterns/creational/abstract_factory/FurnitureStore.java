package designPatterns.creational.abstract_factory;

import designPatterns.creational.abstract_factory.creator.interfaces.FurnitureFactory;

public class FurnitureStore {

    private final FurnitureFactory furnitureFactory;

    public FurnitureStore(FurnitureFactory furnitureFactory) {
        this.furnitureFactory = furnitureFactory;
    }

    public void getFurniture() {
        furnitureFactory.getChair().holdPerson();
        furnitureFactory.getSofa().holdPeople();
        furnitureFactory.getCoffeeTable().holdCoffee();
    }
}
