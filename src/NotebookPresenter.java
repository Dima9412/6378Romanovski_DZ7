import java.time.LocalDate;
import java.time.LocalDateTime;

public class NotebookPresenter {
    private Notebook notebook;
    private NotebookView view;

    public NotebookPresenter(Notebook notebook, NotebookView view) {
        this.notebook = notebook;
        this.view = view;
    }

    public void addNote(String title, LocalDateTime dateTime) {
        Note note = new Note(title, dateTime);
        notebook.addNote(note);
        view.showMessage("Запись добавлена.");
    }

    public void displayNotesForDay(LocalDate date) {
        view.displayNotes(notebook.getNotesForDay(date));
    }

    public void displayNotesForWeek(LocalDate startOfWeek) {
        view.displayNotes(notebook.getNotesForWeek(startOfWeek));
    }
}