import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        ConsoleNotebookView view = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenter(notebook, view);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду (add/view/day/week/exit): ");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    System.out.println("Введите заголовок записи: ");
                    String title = scanner.nextLine();
                    System.out.println("Введите дату и время (yyyy-MM-dd HH:mm): ");
                    LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), ConsoleNotebookView.DATE_FORMATTER);
                    presenter.addNote(title, dateTime);
                    break;

                case "view":
                    System.out.println("Введите дату (yyyy-MM-dd): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    presenter.displayNotesForDay(date);
                    break;

                case "week":
                    System.out.println("Введите начало недели (yyyy-MM-dd): ");
                    LocalDate startOfWeek = LocalDate.parse(scanner.nextLine());
                    presenter.displayNotesForWeek(startOfWeek);
                    break;

                case "exit":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }
}