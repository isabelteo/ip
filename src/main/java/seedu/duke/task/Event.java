package seedu.duke.task;

import java.time.LocalDateTime;

/**
 * Used when user wants to create a {@link Task} with start and end date or time.
 */
public class Event extends Task {
    private final String taskType = "E";

    /**
     * Creates an event.
     * @param taskName for name of task
     */
    public Event(String taskName, LocalDateTime endDate, LocalDateTime startDate) {
        super(taskName, false, endDate, startDate, new NoteList());
    }

    /**
     * Creates an event using another event object.
     * @param oldEvent for previous event
     * @param isDone which is a boolean to denote whether the task is complete
     */
    Event(Event oldEvent, boolean isDone) {
        super(oldEvent.getTaskName(), isDone, oldEvent.getEndDate(),
                oldEvent.getStartDate(), oldEvent.getNotes());
    }

    /**
     * Creates an event.
     * @param taskName for task name
     * @param isDone for whether the task is done
     */
    public Event(String taskName, boolean isDone, LocalDateTime endDate,
                 LocalDateTime startDate, NoteList notes) {
        super(taskName, isDone, endDate, startDate, notes);
    }

    /**
     * Used to update the Event object with a new Note.
     * @param event which contains information to transfer over to new event
     * @param newNoteList which contains the updated information to store to event
     */
    public Event(Event event, NoteList newNoteList) {
        super(event, newNoteList);
    }

    /**
     * {inheritDoc}.
     */
    @Override
    public Task editNoteList(int indexOfNote, String noteContent) {
        NoteList newNoteList = super.getNotes().editNote(indexOfNote, noteContent);
        return new Event(this, newNoteList);
    }

    /**
     * {inheritDoc}.
     */
    @Override
    public Task addNoteToNoteList(Note newNote) {
        NoteList newNoteList = super.getNotes().addNote(newNote);
        return new Event(this, newNoteList);
    }

    /**
     * {inheritDoc}.
     */
    @Override
    public Task deleteNoteFromNoteList(int indexOfNote) {
        NoteList newNoteList = super.getNotes().deleteNote(indexOfNote);
        return new Event(this, newNoteList);
    }

    /**
     * {inheritDoc}.
     */
    @Override
    public Task changeTaskStatus(boolean status) {
        return new Event(this, status);
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
        return "[E]" + super.toString()
                + String.format(" (at: %s to %s)",
                this.getFormattingDateString(this.getStartDate()),
                this.getFormattingDateString(this.getEndDate()));
    }
}
