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

    public static final Task MISSION_1 = new TaskBuilder().withDesc("Mark mission 1").build();
    public static final Task STUDIO = new TaskBuilder().withDesc("Prepare studio 1 slides").build();
    public static final Task QUEST_1 = new TaskBuilder().withDesc("Check quest 1").build();
    public static final Task MASTERY_CHECK = new TaskBuilder().withDesc("Conduct mastery check").build();

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
        return new ArrayList<>(Arrays.asList(MISSION_1, STUDIO, QUEST_1, MASTERY_CHECK));
    }

}
