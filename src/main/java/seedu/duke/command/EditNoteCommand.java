package seedu.duke.command;

import seedu.duke.chatbot.Storage;
import seedu.duke.chatbot.Ui;
import seedu.duke.exceptions.DukeException;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

/**
 * Command used to make chatbot edit a note attached to a Task.
 */
public class EditNoteCommand extends Command {
    private final int taskIndex;
    private final String noteContent;
    private final int noteIndex;

    /**
     * Used to construct a edit note command.
     * @param taskIndex for index of task to edit note from
     * @param noteIndex for index of note to edit
     * @param noteContent for new content to put in the note
     */
    public EditNoteCommand(int taskIndex, int noteIndex, String noteContent) {
        this.taskIndex = taskIndex;
        this.noteIndex = noteIndex;
        this.noteContent = noteContent;
    }

    /**
     *{@inheritDoc}.
     */
    @Override
    public TaskList execute(TaskList taskList, Storage storage) throws DukeException {
        Task taskToAdd = taskList.getTasks().get(taskIndex);
        Task editedTask = taskToAdd.editNoteList(noteIndex, noteContent);
        TaskList newTaskList = taskList.replace(taskIndex, editedTask);
        storage.convertTaskListToFile(newTaskList);
        return newTaskList;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public String getResponseAfterCommand(TaskList taskList) {
        Task updatedTask = taskList.getTasks().get(taskIndex);
        return Ui.showEditNoteResult(taskList, updatedTask);
    }

    /**
     *{@inheritDoc}.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
