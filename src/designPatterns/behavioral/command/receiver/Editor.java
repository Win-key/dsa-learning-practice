package designPatterns.behavioral.command.receiver;

import designPatterns.behavioral.command.Command;
import designPatterns.behavioral.command.app.CommandHistory;

public class Editor {

    private StringBuilder value;
    private CommandHistory commandHistory;
    // clipboard actually should be inside application
    private String clipboard;

    public Editor() {
        this.commandHistory = new CommandHistory();
        this.value = new StringBuilder();
    }

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    public StringBuilder getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = new StringBuilder(value);
    }

    public void setClipBoard(String s) {
        clipboard = s;
    }

    public String getClipBoard() {
        return clipboard;
    }

    public void undo() {
        Command command = commandHistory.pop();
        if(command == null) return;

        command.unExecute();
    }
}
