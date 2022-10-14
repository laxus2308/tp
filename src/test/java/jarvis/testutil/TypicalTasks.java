package jarvis.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jarvis.model.Task;
import jarvis.model.TaskBook;

/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class TypicalTasks {

    public static final Task MISSION1 = new TaskBuilder().withDesc("Mark mission 1").build();
    public static final Task MISSION2 = new TaskBuilder().withDesc("Mark mission 2").build();
    public static final Task QUEST1 = new TaskBuilder().withDesc("Mark quest 1").build();
    public static final Task QUEST2 = new TaskBuilder().withDesc("Mark quest 2").build();

    private TypicalTasks() {} // prevents instantiation

    /**
     * Returns an {@code TaskBook} with all the typical tasks.
     */
    public static TaskBook getTypicalTaskBook() {
        TaskBook tb = new TaskBook();
        for (Task task : getTypicalTasks()) {
            tb.addTask(task);
        }
        return tb;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(MISSION1, MISSION2, QUEST1, QUEST2));
    }

}
