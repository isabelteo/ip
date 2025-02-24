package seedu.duke.task;

import java.time.LocalDateTime;

/**
 * Used when user wants to create a {@link Task} that has a end date but no start date.
 */
public class Deadline extends Task {
    private final String taskType = "D";

    /**
     * Creates a deadline.
     * @param taskName for task name
     * @param date for end date
     */
    public Deadline(String taskName, LocalDateTime date) {
        super(taskName, false, date, null, new NoteList());
    }

    /**
     * Used to update the Deadline object with a new Note.
     * @param deadline which contains information to transfer over to new deadline
     * @param newNoteList which contains the updated information to store to deadline
     */
    public Deadline(Deadline deadline, NoteList newNoteList) {
        super(deadline, newNoteList);
    }

    /**
     * Used to help adjust the done status.
     * @param oldDeadline to extract task name and date
     * @param isDone for specified boolean
     */
    Deadline(Deadline oldDeadline, boolean isDone) {
        super(oldDeadline.getTaskName(), isDone, oldDeadline.getEndDate(), null, new NoteList());
    }

    /**
     * Used when recreating from database.
     * @param taskName for name of task
     * @param isDone for status of task
     * @param date for end date of task
     * @param notes for notes attached to task
     */
    public Deadline(String taskName, boolean isDone, LocalDateTime date, NoteList notes) {
        super(taskName, isDone, date, null, notes);
    }

    /**
     * {inheritDoc}.
     */
    @Override
    public Task editNoteList(int indexOfNote, String noteContent) {
        NoteList newNoteList = super.getNotes().editNote(indexOfNote, noteContent);
        return new Deadline(this, newNoteList);
    }

    /**
     * {inheritDoc}.
     */
    @Override
    public Task addNoteToNoteList(Note newNote) {
        NoteList newNoteList = super.getNotes().addNote(newNote);
        return new Deadline(this, newNoteList);
    }

    /**
     * {inheritDoc}.
     */
    @Override
    public Task deleteNoteFromNoteList(int indexOfNote) {
        NoteList newNoteList = super.getNotes().deleteNote(indexOfNote);
        return new Deadline(this, newNoteList);
    }

    /**
     * {inheritDoc}.
     */
    @Override
    public Task changeTaskStatus(boolean isDone) {
        return new Deadline(this, isDone);
    }

    /**
     * {inheritDoc}.
     */
    @Override
    public String getTaskType() {
        return this.taskType;
    }

    /**
     * {inheritDoc}.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString()
                + String.format(" (by: %s)", this.getFormattingDateString(this.getEndDate()));
    }
}
