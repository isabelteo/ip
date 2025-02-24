package seedu.duke.exceptions;

/**
 * Thrown when a mark or unmark command is executed twice.
 */
public class CommandAlreadyDoneException extends DukeException {
    public CommandAlreadyDoneException() {
        super("Oh hmm...seems like I've executed that already");
    }
}
