package jarvis.testutil;

import jarvis.model.Task;

/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class TypicalTasks {

    public static final Task MISSION1 = new TaskBuilder().withDesc("Mark mission 1").build();
    public static final Task MISSION2 = new TaskBuilder().withDesc("Mark mission 2").build();
    public static final Task QUEST1 = new TaskBuilder().withDesc("Mark quest 1").build();
    public static final Task QUEST2 = new TaskBuilder().withDesc("Mark quest 2").build();


}
