package jarvis.ui;

import java.util.logging.Logger;

import jarvis.commons.core.LogsCenter;
import jarvis.model.Student;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;

/**
 * Panel containing the list of students, fully expanded with all details shown.
 */
public class ExpandedStudentListPanel extends UiPart<Region> {
    private static final String FXML = "ExpandedStudentListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(StudentListPanel.class);

    @FXML
    private ListView<Student> studentListView;

    /**
     * Creates a {@code StudentListPanel} with the given {@code ObservableList}.
     */
    public ExpandedStudentListPanel(ObservableList<Student> studentList) {
        super(FXML);
        super.changeShowingStatus();
        studentListView.setItems(studentList);
        studentListView.setCellFactory(listView -> new StudentListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Student} using a {@code StudentCard}.
     */
    class StudentListViewCell extends ListCell<Student> {
        @Override
        protected void updateItem(Student student, boolean empty) {
            super.updateItem(student, empty);

            if (empty || student == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ExpandedStudentCard(student, getIndex() + 1).getRoot());
            }
        }
    }

}

