package seedu.duke.command;

import seedu.duke.Storage;
import seedu.duke.exceptions.DukeException;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;
import seedu.duke.Ui;

public class DeleteCommand extends Command {
    private final int index;
    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public TaskList execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        TaskList newTaskList = taskList.delete(index);
        Task taskToRemove = taskList.getTasks().get(index);
        ui.showDeleteResult(newTaskList, taskToRemove);
        return newTaskList;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
