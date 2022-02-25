package designPatterns.behavioral.strategy_pattern.solution;

public class SimpleRoute implements IRoute{
    @Override
    public void route() {
        System.out.println("I provide simple routing");
    }
}
