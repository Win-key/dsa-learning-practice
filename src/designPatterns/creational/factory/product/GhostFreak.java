package designPatterns.creational.factory.product;

public class GhostFreak implements AlienForm {

    @Override
    public void speak() {
        System.out.println("Ghost freak... I can invade your body... ");
    }
}
