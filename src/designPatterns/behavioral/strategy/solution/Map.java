package designPatterns.behavioral.strategy.solution;

public class Map {
    private IRoute route;

    public Map(IRoute route) {
        this.route = route;
    }

    public void getRoute() {
        route.route();
    }

}
