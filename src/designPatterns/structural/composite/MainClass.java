package designPatterns.structural.composite;

import utils.Utils;

public class MainClass {

    public static void main(String[] args) {
        ShoppingKart shoppingKart = new ShoppingKart();
        Box box1 = new Box();
        box1.add(new Product("iPhone 12", 80000));
        box1.add(new Product("iPhone 13", 140000));
        box1.add(new Product("iPhone charger", 2000));

        Utils.print("Price of box 1 = " + box1.getPrice());

        shoppingKart.add(box1);
        shoppingKart.add(new Product("iPhone case", 1000));

        Box box2 = new Box();
        box2.add(new Product("Apple watch", 30000));
        box2.add(new Product("Gift card", 200));
        Utils.print("Price of box 2 = " + box2.getPrice());

        shoppingKart.add(box2);

        shoppingKart.move();

        double price = shoppingKart.getPrice();

        Utils.print("Total price of items in your shopping kart : Rs. " + price);
    }

}
