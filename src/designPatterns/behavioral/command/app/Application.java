package designPatterns.behavioral.command.app;

import designPatterns.behavioral.command.impl.WriteCommand;
import designPatterns.behavioral.command.receiver.Editor;

public class Application {

    // there could be multiple editors.
    // receiver
    private Editor editor;

    // user interface
    private Toolbar toolbar;
    private Shortcut shortcut;

    public Application() {
        this.editor = new Editor();
        this.toolbar = new Toolbar(editor);
        this.shortcut = new Shortcut(editor);
    }

    // Write is a command. I ask app to write some text to editor...
    public void writeln(String s) {
        editor.executeCommand(new WriteCommand(s, editor));
    }

    // read is not a command.... Unlike write, I do not do anything special...
    public void read() {
        System.out.println(editor.getValue().toString());
    }

    public GUI selectGui() {
        int x = (int) (Math.random() * 2);
        if(x == 0) return toolbar;
        return shortcut;
    }

    public Editor getEditor() { return editor; }
}
