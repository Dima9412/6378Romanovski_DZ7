import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConsoleNotebookView implements NotebookView {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public void displayNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("Нет записей.");
            return;
        }
        for (Note note : notes) {
            System.out.println(note);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}