package week9.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelBookingWithCommonFee {

    abstract static class Booking {
        private static final double BOOKING_FEE = 50;

        private final double distanceKm;

        Booking(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        double getDistanceKm() {
            return distanceKm;
        }

        abstract String getMode();

        abstract double calculateFare();

        final double calculateTotal() {
            return calculateFare() + BOOKING_FEE;
        }
    }

    static class BusBooking extends Booking {
        BusBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        String getMode() {
            return "BUS";
        }

        @Override
        double calculateFare() {
            return 2.0 * getDistanceKm();
        }
    }

    static class TrainBooking extends Booking {
        TrainBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        String getMode() {
            return "TRAIN";
        }

        @Override
        double calculateFare() {
            return 1.5 * getDistanceKm();
        }
    }

    static class FlightBooking extends Booking {
        private static final double BASE_FARE = 2500;

        FlightBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        String getMode() {
            return "FLIGHT";
        }

        @Override
        double calculateFare() {
            return BASE_FARE + 4.0 * getDistanceKm();
        }
    }

    static Booking createBooking(String[] tokens) {
        String mode = tokens[0];
        double distanceKm = Double.parseDouble(tokens[1]);
        switch (mode) {
            case "BUS":
                return new BusBooking(distanceKm);
            case "TRAIN":
                return new TrainBooking(distanceKm);
            case "FLIGHT":
                return new FlightBooking(distanceKm);
            default:
                throw new IllegalArgumentException("Unknown travel mode: " + mode);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bookingCount = Integer.parseInt(scanner.nextLine().trim());
        List<Booking> bookings = new ArrayList<>();
        while (bookings.size() < bookingCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            bookings.add(createBooking(line.split("\\s+")));
        }

        for (Booking booking : bookings) {
            System.out.printf("%s: %.2f%n", booking.getMode(), booking.calculateTotal());
        }
        scanner.close();
    }
}
