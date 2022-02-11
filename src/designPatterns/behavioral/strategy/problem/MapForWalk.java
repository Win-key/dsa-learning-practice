package designPatterns.behavioral.strategy.problem;

public class MapForWalk extends Map {

    @Override
    public void route() {
        System.out.println("I provide routing for pedestrian");
    }
}
