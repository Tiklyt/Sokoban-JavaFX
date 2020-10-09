package esi.g52816.model;

/**
 *
 * @author bilal
 */
public interface Command {

    /**
     * execute the command
     */
    void execute();

    /**
     * unexecute the command;
     */
    void unexecute();

    /**
     * check if a command can be executed
     *
     * @return true or false
     */
    boolean canExecute();
}
