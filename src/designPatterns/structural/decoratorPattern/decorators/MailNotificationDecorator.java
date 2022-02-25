package designPatterns.structural.decoratorPattern.decorators;

import designPatterns.structural.decoratorPattern.concretion.Notifier;

public class MailNotificationDecorator extends BaseNotificationDecorator {
    public MailNotificationDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        this.notifier.send(message);
        System.out.println("I'm sending a mail notification to the user. " + message);
    }
}
