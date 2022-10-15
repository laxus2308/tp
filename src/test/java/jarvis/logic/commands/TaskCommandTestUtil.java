package jarvis.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Arrays;

import jarvis.commons.core.index.Index;
import jarvis.model.DescContainsKeywordsPredicate;
import jarvis.model.Model;
import jarvis.model.Task;

/**
 * Contains helper methods for testing task commands.
 */
public class TaskCommandTestUtil {

    public static final String VALID_DESC_MISSION1 = "Mark mission 1";
    public static final String VALID_DESC_MISSION2 = "Mark mission 2";

    public static final LocalDate VALID_DEADLINE1 = LocalDate.parse("2022-10-12");

    /**
     * Updates {@code model}'s filtered list to show only the task at the given {@code targetIndex} in the
     * {@code model}'s task book.
     */
    public static void showTaskAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredTaskList().size());

        Task task = model.getFilteredTaskList().get(targetIndex.getZeroBased());
        final String[] splitDesc = task.getDesc().taskDesc.split("\\s+");
        System.out.println(splitDesc[0]);
        model.updateFilteredTaskList(new DescContainsKeywordsPredicate(Arrays.asList(splitDesc[0])));

        assertEquals(1, model.getFilteredTaskList().size());
    }
}
