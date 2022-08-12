package designPatterns.behavioral.templateMethod;

import utils.Utils;

public class WoodenHouseBuilding extends HouseBuildingTemplate {

    public WoodenHouseBuilding() {
        super("Wooden");
    }

    @Override
    public void planning() {
        Utils.print("Planing created for wooden house");
    }

    @Override
    public void materialCollection() {
        Utils.print("Material collection for the wooden house building");
    }

    @Override
    public void gatherWorkers() {
        super.gatherWorkers();
        Utils.print("Get few workers specialized in wooden house construction");
    }

    @Override
    public void optionalFood() {
        Utils.print("Provide food for construction workers");
    }

    @Override
    public void optionalTravelFacility() {
        Utils.print("Provide travel facilities for workers");
    }
}
