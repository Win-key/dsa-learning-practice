package designPatterns.behavioral.strategy_pattern.problem;

public class MapForTwoWheelersWithTraffic extends MapForTwoWheeler {

    @Override
    public void route() {
        super.route();
        System.out.println("I have behaviour of MapForTwoWheeler. Also I provide traffic insights on top of it.");
    }
}
