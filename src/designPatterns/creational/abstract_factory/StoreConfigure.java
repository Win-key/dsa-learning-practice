package designPatterns.creational.abstract_factory;

import designPatterns.creational.abstract_factory.creator.concrete.ModernFurnitureFactory;
import designPatterns.creational.abstract_factory.creator.concrete.TraditionalFurnitureFactory;

public class StoreConfigure {

    public static void main(String[] args) {
        configure((int) (Math.random() * 2));
    }

    public static void configure(int x) {

        FurnitureStore furnitureStore;

        if (x == 0) {
            furnitureStore = new FurnitureStore(new TraditionalFurnitureFactory());
        } else {
            furnitureStore = new FurnitureStore(new ModernFurnitureFactory());
        }

        furnitureStore.getFurniture();

    }

}
