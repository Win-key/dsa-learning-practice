package designPatterns.behavioral.command.app;

// A receiver can be capable of multiple operations...
public interface GUI {

    void copy(int s, int e);
    void paste();
    void undo();
}
