package jarvis.testutil;


import static jarvis.logic.parser.CliSyntax.PREFIX_NAME;

import jarvis.logic.commands.AddTaskCommand;
import jarvis.model.Task;

/**
 * A utility class for Task.
 */
public class TaskUtil {
    /**
     * Returns an add task command string for adding the {@code task}.
     */
    public static String getAddTaskCommand(Task task) {
        return AddTaskCommand.COMMAND_WORD + " " + getTaskDetails(task);
    }

    /**
     * Returns the part of command string for the given {@code task}'s details.
     */
    public static String getTaskDetails(Task task) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + task.getDesc().taskDesc + " ");
        return sb.toString();
    }
}
