package designPatterns.creational.factory.product;

public class DiamondHead implements AlienForm {
    @Override
    public void speak() {
        System.out.println("Diamond head... I'm gonna break your head... Ehhhh...");
    }
}
