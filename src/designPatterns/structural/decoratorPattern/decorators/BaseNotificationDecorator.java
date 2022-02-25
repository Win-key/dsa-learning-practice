package designPatterns.structural.decoratorPattern.decorators;

import designPatterns.structural.decoratorPattern.concretion.Notifier;

public abstract class BaseNotificationDecorator implements Notifier {
    protected Notifier notifier;

    public BaseNotificationDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
}
