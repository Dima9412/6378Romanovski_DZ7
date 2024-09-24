import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Notebook {
    private List<Note> notes;

    public Notebook() {
        notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotesForDay(LocalDate date) {
        return notes.stream()
                .filter(note -> note.getDateTime().toLocalDate().isEqual(date))
                .sorted((n1, n2) -> n1.getDateTime().compareTo(n2.getDateTime()))
                .collect(Collectors.toList());
    }

    public List<Note> getNotesForWeek(LocalDate startOfWeek) {
        return notes.stream()
                .filter(note -> !note.getDateTime().toLocalDate().isBefore(startOfWeek)
                        && !note.getDateTime().toLocalDate().isAfter(startOfWeek.plusDays(6)))
                .sorted((n1, n2) -> n1.getDateTime().compareTo(n2.getDateTime()))
                .collect(Collectors.toList());
    }

    // Методы для сериализации и десериализации записей...
}