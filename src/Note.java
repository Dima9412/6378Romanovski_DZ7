import java.time.LocalDateTime;

public class Note {
    private String title;
    private LocalDateTime dateTime;

    public Note(String title, LocalDateTime dateTime) {
        this.title = title;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return dateTime + ": " + title;
    }
}