package seedu.duke.exceptions;

public class DukeException extends Exception {

    public DukeException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}