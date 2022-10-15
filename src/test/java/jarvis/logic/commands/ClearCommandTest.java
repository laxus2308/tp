package jarvis.logic.commands;

import static jarvis.logic.commands.StudentCommandTestUtil.assertCommandSuccess;
import static jarvis.testutil.TypicalStudents.getTypicalStudentBook;
import static jarvis.testutil.TypicalTasks.getTypicalTaskBook;

import org.junit.jupiter.api.Test;

import jarvis.model.Model;
import jarvis.model.ModelManager;
import jarvis.model.StudentBook;
import jarvis.model.TaskBook;
import jarvis.model.UserPrefs;

public class ClearCommandTest {

    @Test
    public void execute_emptyJarvis_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyJarvis_success() {
        Model model = new ModelManager(getTypicalStudentBook(), getTypicalTaskBook(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalStudentBook(), getTypicalTaskBook(), new UserPrefs());
        expectedModel.setStudentBook(new StudentBook());
        expectedModel.setTaskBook(new TaskBook());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
