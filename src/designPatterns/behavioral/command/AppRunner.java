package designPatterns.behavioral.command;

import designPatterns.behavioral.command.app.Application;

public class AppRunner {
    public static void main(String[] args) {
        Application application = new Application();
        application.writeln("Hi.. I'm Venkatesh Rajendran. ");
        application.writeln("I'm a software engineer.");

        application.read();
        application.writeln("I live in chennai.");
        application.selectGui().copy(9, 29);
        application.selectGui().paste();
        application.selectGui().paste();
        application.selectGui().paste();
        application.selectGui().paste();
        application.read();

        application.selectGui().undo();
        application.selectGui().undo();
        application.selectGui().undo();
        application.selectGui().undo();
        application.read();

    }
}
