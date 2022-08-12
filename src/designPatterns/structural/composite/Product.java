package designPatterns.structural.composite;

public class Product implements Item {

    private final double price;
    private final String name;

    public Product(String name, double price) {
        if(price < 1) throw new IllegalStateException("Price cannot be empty or zero");
        this.price = price;
        this.name = name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
