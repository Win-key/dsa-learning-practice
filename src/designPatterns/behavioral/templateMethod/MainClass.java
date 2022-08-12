package designPatterns.behavioral.templateMethod;

public class MainClass {

    public static void main(String[] args) {
        HouseBuildingTemplate woodenBuilding = new WoodenHouseBuilding();
        woodenBuilding.buildTemplate();

        /*Starting Wooden building construction.
        Selecting land for building house
        Planing created for wooden house
        Material collection for the wooden house building
        Get typical construction people
        Get few workers specialized in wooden house construction
        Pay workers based on their work.
        Provide food for construction workers
        Provide travel facilities for workers
        Paint house
        Complete the project. Handover to owner
        Completing Wooden building construction.*/

        HouseBuildingTemplate cementBuilding = new CementHouseBuilding();
        cementBuilding.buildTemplate();

        /*Starting Cement building construction.
        Selecting land for building house
        Planing created for cement house
        Material collection for the cement house building
        Get typical construction people
        Get few masons for cement house construction
        Pay workers based on their work.
        Provide food for construction workers
        Paint house
        Complete the project. Handover to owner
        Completing Cement building construction.*/

    }

}
