package seedu.duke.command;

import seedu.duke.chatbot.Storage;
import seedu.duke.chatbot.Ui;
import seedu.duke.exceptions.DukeException;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

/**
 * Executes the adding of {@link Task} to {@link TaskList}.
 */
public class AddCommand extends Command {
    private final Task taskToAdd;

    /**
     * Creates a AddCommand.
     * @param taskToAdd is the {@link Task} to be added to the {@link TaskList}
     */
    public AddCommand(Task taskToAdd) {
        this.taskToAdd =  taskToAdd;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskList execute(TaskList taskList, Storage storage) throws DukeException {
        try {
            TaskList newTaskList = taskList.add(taskToAdd);
            String lineToAdd = storage.createSummaryFromTask(this.taskToAdd);
            storage.addLine(lineToAdd);
            return newTaskList;
        } catch (NullPointerException e) {
            throw new DukeException("Can't add the task because the command is wrong. Can you try again?");
        }
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public String getResponseAfterCommand(TaskList taskList) {
        return Ui.showAddResult(taskList, taskToAdd);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public boolean isExit() {
        return false;
    }
}