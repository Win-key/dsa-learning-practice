package designPatterns.structural.decoratorPattern;

import designPatterns.structural.decoratorPattern.concretion.Notifier;
import designPatterns.structural.decoratorPattern.concretion.SimpleNotifier;
import designPatterns.structural.decoratorPattern.decorators.CallNotificationDecorator;
import designPatterns.structural.decoratorPattern.decorators.MailNotificationDecorator;
import designPatterns.structural.decoratorPattern.decorators.SlackNotificationDecorator;

public class DecoratorMainClass {
    public static void main(String[] args) {
        Notifier simpleNotifier = new SimpleNotifier();

        Notifier mailNotifier = new MailNotificationDecorator(simpleNotifier);
        Notifier slackMailNotifier = new SlackNotificationDecorator(mailNotifier);
        Notifier callNotifier = new CallNotificationDecorator(simpleNotifier);

        Notifier slackMailCallNotifier = new CallNotificationDecorator(slackMailNotifier);

        simpleNotifier.send("From simple notifier");
        System.out.println();
        mailNotifier.send("From mailNotifier");
        System.out.println();
        slackMailNotifier.send("From slackMailNotifier");
        System.out.println();
        callNotifier.send("From callNotifier");
        System.out.println();
        slackMailCallNotifier.send("From slackMailCallNotifier");


    }
}
