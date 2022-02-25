package designPatterns.structural.decoratorPattern.concretion;

public class SimpleNotifier implements Notifier {

    @Override
    public void send(String message) {
        // Web push is a concept of js which
        // creates a worker thread in the client system which act as server and
        // notification service sends the notification to the worker thread
        System.out.println("I'm a simple web push notification. " + message);
    }
}
