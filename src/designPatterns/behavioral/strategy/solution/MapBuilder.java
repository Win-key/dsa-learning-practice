package designPatterns.behavioral.strategy.solution;

public class MapBuilder {

    private MapBuilder() { }

    public static Map build(String strategy) {

        switch (strategy) {
            case "Simple":
                return new Map(new SimpleRoute());
            case "Walk":
                return new Map(new WalkingRoute());
            case "TwoWheeler":
                return new Map(new TwoWheelerRoute());
            default:
                throw new IllegalStateException("Given strategy is not supported.");
        }

    }
}
