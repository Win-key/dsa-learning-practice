package designPatterns.behavioral.command.impl;

import designPatterns.behavioral.command.Command;
import designPatterns.behavioral.command.receiver.Editor;

public class WriteCommand implements Command {
    private String value;
    private String backup;
    private Editor editor;

    public WriteCommand(String value, Editor editor) {
        this.value = value;
        this.editor = editor;
    }

    @Override
    public void execute() {
        this.backup = editor.getValue().toString();
        editor.getValue().append(value).append("\n");
    }

    @Override
    public void unExecute() {
        editor.setValue(backup);
    }
}
