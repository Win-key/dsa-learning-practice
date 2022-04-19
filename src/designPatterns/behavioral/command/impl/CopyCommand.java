package designPatterns.behavioral.command.impl;

import designPatterns.behavioral.command.Command;
import designPatterns.behavioral.command.receiver.Editor;

public class CopyCommand implements Command {

    private int start, end;
    private Editor editor;
    private String backup;

    public CopyCommand(int start, int end, Editor editor) {
        this.start = start;
        this.end = end;
        this.editor = editor;
    }

    @Override
    public void execute() {
        backup = editor.getClipBoard();
        editor.setClipBoard(editor.getValue().substring(start, end));
    }

    @Override
    public void unExecute() {
        editor.setClipBoard(backup);
    }
}