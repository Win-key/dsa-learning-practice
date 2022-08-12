package designPatterns.structural.composite;

import java.util.LinkedList;
import java.util.List;

public class Box implements Item {

    private List<Item> items;

    public Box() {
        this.items = new LinkedList<>();
    }

    public Box(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public double getPrice() {
        return items
                .stream()
                .mapToDouble(Item::getPrice)
                .reduce(Double::sum)
                .orElse(0);
    }
}
