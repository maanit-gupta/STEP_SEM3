package week8.classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransportFareCalculator {

    abstract static class Transport {
        private final double distance;

        Transport(double distance) {
            this.distance = distance;
        }

        double getDistance() {
            return distance;
        }

        abstract String getType();

        abstract double calculateFare();
    }

    static class Bus extends Transport {
        Bus(double distance) {
            super(distance);
        }

        @Override
        String getType() {
            return "BUS";
        }

        @Override
        double calculateFare() {
            return Math.min(2 + 0.10 * getDistance(), 10);
        }
    }

    static class Train extends Transport {
        Train(double distance) {
            super(distance);
        }

        @Override
        String getType() {
            return "TRAIN";
        }

        @Override
        double calculateFare() {
            return 3 + 0.15 * getDistance();
        }
    }

    static class Metro extends Transport {
        private final double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        String getType() {
            return "METRO";
        }

        @Override
        double calculateFare() {
            return (1.50 + 0.20 * getDistance()) * peakHourFactor;
        }
    }

    static Transport createTransport(String[] tokens) {
        String type = tokens[0];
        double distance = Double.parseDouble(tokens[1]);
        switch (type) {
            case "BUS":
                return new Bus(distance);
            case "TRAIN":
                return new Train(distance);
            case "METRO":
                return new Metro(distance, Double.parseDouble(tokens[2]));
            default:
                throw new IllegalArgumentException("Unknown transport type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int journeyCount = Integer.parseInt(scanner.nextLine().trim());
        List<Transport> journeys = new ArrayList<>();
        while (journeys.size() < journeyCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            journeys.add(createTransport(line.split("\\s+")));
        }

        double total = 0;
        for (Transport journey : journeys) {
            double fare = journey.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", journey.getType(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
