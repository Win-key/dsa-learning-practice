package designPatterns.structural.decoratorPattern.decorators;

import designPatterns.structural.decoratorPattern.concretion.Notifier;

public class SlackNotificationDecorator extends BaseNotificationDecorator {
    public SlackNotificationDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        this.notifier.send(message);
        System.out.println("I'm sending a slack notification to the user. " + message);
    }
}
