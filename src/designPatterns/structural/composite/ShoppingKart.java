package designPatterns.structural.composite;

import utils.Utils;

public class ShoppingKart extends Box {

    @Override
    public double getPrice() {
        double total = super.getPrice();
        return Math.floor(total);
    }

    public void move() {
        Utils.print("Shopping kart can be used for holding items" +
                " and move around the shop");
    }
}
