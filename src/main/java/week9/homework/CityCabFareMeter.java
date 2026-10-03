package week9.homework;

import java.util.Scanner;

public class CityCabFareMeter {

    interface NightService {
        double NIGHT_SURCHARGE_RATE = 0.20;

        default double applyNightCharge(double fare) {
            return fare * (1 + NIGHT_SURCHARGE_RATE);
        }
    }

    abstract static class Cab {
        private static final double MINIMUM_FARE = 100;

        private final double distanceKm;

        Cab(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        abstract String getType();

        abstract double getRatePerKm();

        final double calculateFare() {
            return Math.max(distanceKm * getRatePerKm(), MINIMUM_FARE);
        }
    }

    static class MiniCab extends Cab {
        MiniCab(double distanceKm) {
            super(distanceKm);
        }

        @Override
        String getType() {
            return "MINI";
        }

        @Override
        double getRatePerKm() {
            return 10;
        }
    }

    static class SedanCab extends Cab implements NightService {
        SedanCab(double distanceKm) {
            super(distanceKm);
        }

        @Override
        String getType() {
            return "SEDAN";
        }

        @Override
        double getRatePerKm() {
            return 14;
        }
    }

    static class SuvCab extends Cab implements NightService {
        SuvCab(double distanceKm) {
            super(distanceKm);
        }

        @Override
        String getType() {
            return "SUV";
        }

        @Override
        double getRatePerKm() {
            return 18;
        }
    }

    static Cab createCab(String type, double distanceKm) {
        switch (type) {
            case "MINI":
                return new MiniCab(distanceKm);
            case "SEDAN":
                return new SedanCab(distanceKm);
            case "SUV":
                return new SuvCab(distanceKm);
            default:
                throw new IllegalArgumentException("Unknown cab type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tripCount = Integer.parseInt(scanner.nextLine().trim());
        double total = 0;
        int processed = 0;
        while (processed < tripCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            processed++;
            String[] tokens = line.split("\\s+");
            Cab cab = createCab(tokens[0], Double.parseDouble(tokens[1]));
            boolean isNightTrip = tokens[2].equals("NIGHT");
            double fare = cab.calculateFare();
            if (isNightTrip) {
                if (!(cab instanceof NightService nightService)) {
                    System.out.printf("%s: night service not available%n", cab.getType());
                    continue;
                }
                fare = nightService.applyNightCharge(fare);
            }
            total += fare;
            System.out.printf("%s: %.2f%n", cab.getType(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
