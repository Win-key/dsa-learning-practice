package designPatterns.behavioral.strategy.solution;

public class TwoWheelerRoute implements IRoute {

    @Override
    public void route() {
        System.out.println("I provide routing for two wheelers.");
    }
}
