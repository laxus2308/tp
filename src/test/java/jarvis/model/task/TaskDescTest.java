package jarvis.model.task;

import static jarvis.testutil.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import jarvis.model.TaskDesc;

public class TaskDescTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TaskDesc(null));
    }

    @Test
    public void constructor_invalidDesc_throwsIllegalArgumentException() {
        String invalidDesc = "";
        assertThrows(IllegalArgumentException.class, () -> new TaskDesc(invalidDesc));
    }

    @Test
    public void isValidDesc() {
        // null desc
        assertThrows(NullPointerException.class, () -> TaskDesc.isValidDesc(null));

        // invalid description
        assertFalse(TaskDesc.isValidDesc("")); // empty string
        assertFalse(TaskDesc.isValidDesc(" ")); // spaces only

        // valid description
        assertTrue(TaskDesc.isValidDesc("Prepare slides for studio 1")); // alphanumeric characters with capital letter
        assertTrue(TaskDesc.isValidDesc("Grade quest 3!!!")); // symbols allowed
    }
}
