package designPatterns.behavioral.command.app;

import designPatterns.behavioral.command.impl.CopyCommand;
import designPatterns.behavioral.command.impl.PasteCommand;
import designPatterns.behavioral.command.receiver.Editor;

public class Shortcut implements GUI {

    private Editor editor;

    public Shortcut(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void copy(int s, int e) {
        System.out.println("I use Shortcut for copy!!");
        editor.executeCommand(new CopyCommand(s, e, editor));
    }

    @Override
    public void paste() {
        System.out.println("I use Shortcut for paste!!");
        editor.executeCommand(new PasteCommand(editor));
    }

    @Override
    public void undo() {
        editor.undo();
    }
}
