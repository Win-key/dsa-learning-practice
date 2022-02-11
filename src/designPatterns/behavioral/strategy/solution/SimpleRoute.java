package designPatterns.behavioral.strategy.solution;

public class SimpleRoute implements IRoute{
    @Override
    public void route() {
        System.out.println("I provide simple routing");
    }
}
