package seedu.duke;


public abstract class Task {
    /**
     * taskName refers to the name of the task.
     */
    private final String taskName;
    /**
     * done records if a task has been marked as complete.
     */
    private final boolean done;

    /**
     * Constructor for a task.
     * @param name refers to the task name
     */
    Task(String name) {
        this.taskName = name;
        this.done = false;
    }

    /**
     * Constructor for a task that consists of task name and boolean done for task status.
     * @param name refers to the task name
     * @param doneStatus refers to the boolean that tracks if a task is complete
     */
    Task(String name, boolean doneStatus) {
        this.taskName = name;
        this.done = doneStatus;
    }

    /**
     * Checks whether the task has been completed.
     * @return boolean of this done.
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Gets the taskName of the taskList.
     * @return String task name
     */
    String getTaskName() {
        return this.taskName;
    }
    /**
     * Marks task as done.or undone.
     * @return new Task with done attribute as the boolean parameter
     */
    abstract Task changeTaskStatus(boolean status);

    /**
     * prints task.
     * @return String with task type, status and name
     */
    @Override
    public String toString() {
        String marked = this.isDone() ? "X" : " ";
        return String.format("[%s] %s", marked, this.taskName);
    }
}
