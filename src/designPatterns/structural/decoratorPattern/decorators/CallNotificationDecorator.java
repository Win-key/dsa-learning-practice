package designPatterns.structural.decoratorPattern.decorators;

import designPatterns.structural.decoratorPattern.concretion.Notifier;

public class CallNotificationDecorator extends BaseNotificationDecorator {

    public CallNotificationDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        this.notifier.send(message);
        System.out.println("I'm making a call to the user. " + message);
    }
}
