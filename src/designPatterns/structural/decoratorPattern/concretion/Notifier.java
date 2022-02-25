package designPatterns.structural.decoratorPattern.concretion;

// We could make this as an abstract class
// if we have a common method that needs to be associated with the notifier
public interface Notifier {

    void send(String message);

}
