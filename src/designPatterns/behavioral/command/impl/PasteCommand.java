package designPatterns.behavioral.command.impl;

import designPatterns.behavioral.command.Command;
import designPatterns.behavioral.command.receiver.Editor;

public class PasteCommand implements Command {
    private String backup;
    private Editor editor;

    public PasteCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        backup = editor.getValue().toString();
        editor.getValue().append(editor.getClipBoard()).append("\n");
    }

    @Override
    public void unExecute() {
        editor.setValue(backup);
    }
}
