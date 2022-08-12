package designPatterns.behavioral.templateMethod;

import utils.Utils;

abstract public class HouseBuildingTemplate {

    private String type;

    public HouseBuildingTemplate(String type) {
        this.type = type;
    }

    // template method
    public final void buildTemplate() {
        Utils.print("Starting " + type + " building construction.");
        selectLand();
        planning();
        materialCollection();
        gatherWorkers();
        payWorker();
        optionalFood();
        optionalTravelFacility();
        paintHouse();
        handover();
        Utils.print("Completing " + type + " building construction.");
        Utils.print("");
    }

    // select a land to build a house
    public void selectLand() {
        Utils.print("Selecting land for building house");
    }

    // plan - should be based on what type of build we are building
    abstract public void planning();
    // raw materials
    abstract public void materialCollection();

    // this can be overridden - Sometime we need worker expert on a job
    public void gatherWorkers() {
        Utils.print("Get typical construction people");
    }

    // pay workers
    public void payWorker() {
        Utils.print("Pay workers based on their work.");
    }
    // provide optional food
    public void optionalFood() {
        // optional hook
    }
    // provide optional travel facility in case site is in remote place
    public void optionalTravelFacility() {
        // optional hook
    }
    // paint house complete
    public void paintHouse() {
        Utils.print("Paint house");
    }
    // hand over to owner
    public void handover() {
        Utils.print("Complete the project. Handover to owner");
    }
}
