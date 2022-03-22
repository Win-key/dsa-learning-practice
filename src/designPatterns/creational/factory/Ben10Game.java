package designPatterns.creational.factory;

import designPatterns.creational.factory.creator.BalancedOmnitrix;
import designPatterns.creational.factory.creator.Omnitrix;
import designPatterns.creational.factory.creator.RandomOmnitrix;

public class Ben10Game {

    public static void main(String[] args) {
        System.out.println("BalancedOmnitrix");
        Omnitrix omnitrix = new BalancedOmnitrix();
        omnitrix.transform().speak();
        omnitrix.transform().speak();
        omnitrix.transform().speak();
        omnitrix.transform().speak();
        omnitrix.transform().speak();
        omnitrix.transform().speak();
        omnitrix.transform().speak();
        omnitrix.transform().speak();

        System.out.println("RandomOmnitrix");
        omnitrix = new RandomOmnitrix();
        omnitrix.transform().speak();
        omnitrix.transform().speak();
        omnitrix.transform().speak();
        omnitrix.transform().speak();
        omnitrix.transform().speak();

    }

}
