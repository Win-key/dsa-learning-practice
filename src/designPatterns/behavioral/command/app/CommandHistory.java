package designPatterns.behavioral.command.app;

import designPatterns.behavioral.command.Command;

import java.util.Stack;

public class CommandHistory {

    private final Stack<Command> commands;

    public CommandHistory() {
        this.commands = new Stack<>();
    }

    public Command pop() {
        return commands.pop();
    }

    public void push(Command command) {
        commands.add(command);
    }

}
