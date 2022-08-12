package designPatterns.behavioral.templateMethod;

import utils.Utils;

public class CementHouseBuilding extends HouseBuildingTemplate {

    public CementHouseBuilding() {
        super("Cement");
    }

    @Override
    public void planning() {
        Utils.print("Planing created for cement house");
    }

    @Override
    public void materialCollection() {
        Utils.print("Material collection for the cement house building");
    }

    @Override
    public void gatherWorkers() {
        super.gatherWorkers();
        Utils.print("Get few masons for cement house construction");
    }

    @Override
    public void optionalFood() {
        Utils.print("Provide food for construction workers");
    }

    // no travel facility as site is not in remote area
}
