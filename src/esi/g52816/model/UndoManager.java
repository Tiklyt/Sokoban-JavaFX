package esi.g52816.model;

import java.util.Observable;
import java.util.Stack;

/**
 * Class managing the undo redo design pattern
 *
 * @author braro
 */
public class UndoManager extends Observable {

    private final Stack<Command> undoStack = new Stack<>();
    private final Stack<Command> redoStack = new Stack<>();

    /**
     * Undo the last command
     *
     * @return true if success
     */
    public boolean undo() {
        if (!undoStack.empty()) {
            undoStack.peek().unexecute();
            redoStack.push(undoStack.pop());
            return true;
        }
        return false;
    }

    /**
     * Redo the last command
     *
     * @return true if success
     */
    public boolean redo() {

        if (!redoStack.isEmpty()) {
            redoStack.peek().execute();
            undoStack.push(redoStack.pop());
            return true;
        }
        return false;
    }

    /**
     * run the command received in parameter
     *
     * @param command the command that will be executed
     */
    public void doIt(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

}
