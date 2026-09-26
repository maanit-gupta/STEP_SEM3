package week8.classwork;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryDueDateCalculator {

    private static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    abstract static class LibraryItem {
        private final String title;

        LibraryItem(String title) {
            this.title = title;
        }

        String getTitle() {
            return title;
        }

        abstract int getLoanPeriodDays();

        LocalDate calculateDueDate(LocalDate borrowDate) {
            return borrowDate.plusDays(getLoanPeriodDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }

        @Override
        int getLoanPeriodDays() {
            return 14;
        }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title) {
            super(title);
        }

        @Override
        int getLoanPeriodDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }

        @Override
        int getLoanPeriodDays() {
            return 3;
        }
    }

    static LibraryItem createItem(String type, String title) {
        switch (type) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new Dvd(title);
            case "MAGAZINE":
                return new Magazine(title);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int itemCount = Integer.parseInt(scanner.nextLine().trim());
        Pattern linePattern = Pattern.compile("^(\\S+)\\s+\"(.*)\"$");
        List<LibraryItem> items = new ArrayList<>();
        while (items.size() < itemCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            Matcher matcher = linePattern.matcher(line);
            if (matcher.matches()) {
                items.add(createItem(matcher.group(1), matcher.group(2)));
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateDueDate(CURRENT_DATE));
        }
        scanner.close();
    }
}
