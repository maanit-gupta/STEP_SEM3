package week9.classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryLateFineCounter {

    abstract static class LibraryItem {
        private final String title;
        private final int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        String getTitle() {
            return title;
        }

        int getDaysLate() {
            return daysLate;
        }

        abstract double calculateFine();
    }

    static class Book extends LibraryItem {
        Book(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        double calculateFine() {
            return 2.0 * getDaysLate();
        }
    }

    static class Dvd extends LibraryItem {
        private static final double MAX_FINE = 50;

        Dvd(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        double calculateFine() {
            return Math.min(5.0 * getDaysLate(), MAX_FINE);
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        double calculateFine() {
            return 1.0 * getDaysLate();
        }
    }

    static LibraryItem createItem(String[] tokens) {
        String type = tokens[0];
        String title = tokens[1];
        int daysLate = Integer.parseInt(tokens[2]);
        switch (type) {
            case "BOOK":
                return new Book(title, daysLate);
            case "DVD":
                return new Dvd(title, daysLate);
            case "MAGAZINE":
                return new Magazine(title, daysLate);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int itemCount = Integer.parseInt(scanner.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        while (items.size() < itemCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            items.add(createItem(line.split("\\s+")));
        }

        double totalFines = 0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
        scanner.close();
    }
}
