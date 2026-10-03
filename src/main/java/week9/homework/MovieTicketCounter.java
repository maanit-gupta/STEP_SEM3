package week9.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieTicketCounter {

    abstract static class Ticket {
        private static final double CONVENIENCE_FEE = 20;

        private final int count;

        Ticket(int count) {
            this.count = count;
        }

        abstract String getSeatType();

        abstract double getPricePerTicket();

        final double calculateAmount() {
            return count * (getPricePerTicket() + CONVENIENCE_FEE);
        }
    }

    static class RegularTicket extends Ticket {
        RegularTicket(int count) {
            super(count);
        }

        @Override
        String getSeatType() {
            return "REGULAR";
        }

        @Override
        double getPricePerTicket() {
            return 150;
        }
    }

    static class PremiumTicket extends Ticket {
        PremiumTicket(int count) {
            super(count);
        }

        @Override
        String getSeatType() {
            return "PREMIUM";
        }

        @Override
        double getPricePerTicket() {
            return 250;
        }
    }

    static class ReclinerTicket extends Ticket {
        ReclinerTicket(int count) {
            super(count);
        }

        @Override
        String getSeatType() {
            return "RECLINER";
        }

        @Override
        double getPricePerTicket() {
            return 400;
        }
    }

    static Ticket createTicket(String[] tokens) {
        String seat = tokens[0];
        int count = Integer.parseInt(tokens[1]);
        switch (seat) {
            case "REGULAR":
                return new RegularTicket(count);
            case "PREMIUM":
                return new PremiumTicket(count);
            case "RECLINER":
                return new ReclinerTicket(count);
            default:
                throw new IllegalArgumentException("Unknown seat type: " + seat);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bookingCount = Integer.parseInt(scanner.nextLine().trim());
        List<Ticket> tickets = new ArrayList<>();
        while (tickets.size() < bookingCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            tickets.add(createTicket(line.split("\\s+")));
        }

        double total = 0;
        for (Ticket ticket : tickets) {
            double amount = ticket.calculateAmount();
            total += amount;
            System.out.printf("%s: %.2f%n", ticket.getSeatType(), amount);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
