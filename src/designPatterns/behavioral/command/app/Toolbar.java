package designPatterns.behavioral.command.app;

import designPatterns.behavioral.command.impl.CopyCommand;
import designPatterns.behavioral.command.impl.PasteCommand;
import designPatterns.behavioral.command.receiver.Editor;

// Toolbar might be having buttons in it. But lets say toolbar can to copy and paste
public class Toolbar implements GUI {

    private Editor editor;

    public Toolbar(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void copy(int s, int e) {
        System.out.println("I use toolbar for copy!!");
        editor.executeCommand(new CopyCommand(s, e, editor));
    }

    @Override
    public void paste() {
        System.out.println("I use toolbar for paste!!");
        editor.executeCommand(new PasteCommand(editor));
    }

    @Override
    public void undo() {
        editor.undo();
    }
}
