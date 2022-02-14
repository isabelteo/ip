package seedu.duke.command;

import seedu.duke.chatbot.Storage;
import seedu.duke.exceptions.DukeException;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;
import seedu.duke.chatbot.Ui;

/**
 * Executes the deleting of a {@link Task} from {@link TaskList}.
 */
public class DeleteCommand extends Command {
    private final int index;

    /**
     * Creates a DeleteCommand object.
     * @param index which is the index of the {@link Task} to delete in {@link TaskList}
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     *{@inheritDoc}.
     */
    @Override
    public TaskList execute(TaskList taskList, Storage storage) throws DukeException {
        Task taskToRemove = taskList.getTasks().get(index);
        TaskList newTaskList = taskList.delete(index);
        String lineToRemove = storage.createSummaryFromTask(taskToRemove);
        storage.convertTaskListToFile(newTaskList);
        return newTaskList;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public String getResponseAfterCommand(TaskList taskList) {
        return Ui.showDeleteResult(taskList);
    }

    /**
     *{@inheritDoc}.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
