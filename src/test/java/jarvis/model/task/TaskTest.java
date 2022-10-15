package jarvis.model.task;

import static jarvis.logic.commands.TaskCommandTestUtil.VALID_DEADLINE1;
import static jarvis.logic.commands.TaskCommandTestUtil.VALID_DESC_MISSION2;
import static jarvis.testutil.TypicalTasks.MISSION_1;
import static jarvis.testutil.TypicalTasks.STUDIO;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import jarvis.model.Task;
import jarvis.testutil.TaskBuilder;

public class TaskTest {

    @Test
    public void isSameTask() {
        // same object -> returns true
        assertTrue(MISSION_1.isSameTask(MISSION_1));

        // null -> returns false
        assertFalse(MISSION_1.isSameTask(null));

        // same desc -> returns true
        Task editedMission1 = new TaskBuilder(MISSION_1).build();
        assertTrue(MISSION_1.isSameTask(editedMission1));

        // same desc but different deadline -> returns true
        editedMission1 = new TaskBuilder(MISSION_1).withDeadline(VALID_DEADLINE1).build();
        assertTrue(MISSION_1.isSameTask(editedMission1));

        // different desc -> returns false
        editedMission1 = new TaskBuilder(MISSION_1).withDesc(VALID_DESC_MISSION2).build();
        assertFalse(MISSION_1.isSameTask(editedMission1));

        // desc differs in case -> returns false
        Task editedMission2 = new TaskBuilder(STUDIO).withDesc(VALID_DESC_MISSION2.toLowerCase()).build();
        assertFalse(STUDIO.isSameTask(editedMission2));

        // desc has trailing spaces -> returns false
        String descWithTrailingSpaces = VALID_DESC_MISSION2 + " ";
        editedMission2 = new TaskBuilder(STUDIO).withDesc(descWithTrailingSpaces).build();
        assertFalse(STUDIO.isSameTask(editedMission2));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Task mission1Copy = new TaskBuilder(MISSION_1).build();
        assertTrue(MISSION_1.equals(mission1Copy));

        // same object -> returns true
        assertTrue(MISSION_1.equals(MISSION_1));

        // null -> returns false
        assertFalse(MISSION_1.equals(null));

        // different type -> returns false
        assertFalse(MISSION_1.equals(5));

        // different task -> returns false
        assertFalse(MISSION_1.equals(STUDIO));

        // different desc -> returns false
        Task editedMission1 = new TaskBuilder(MISSION_1).withDesc(VALID_DESC_MISSION2).build();
        assertFalse(MISSION_1.equals(editedMission1));

        // different deadline -> returns false
        editedMission1 = new TaskBuilder(MISSION_1).withDeadline(VALID_DEADLINE1).build();
        assertFalse(MISSION_1.equals(editedMission1));
    }
}
