package week8.classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryFeeCalculator {

    abstract static class Delivery {
        private final double weight;
        private final double distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        double getWeight() {
            return weight;
        }

        double getDistance() {
            return distance;
        }

        abstract String getType();

        abstract double calculateFee();
    }

    static class StandardDelivery extends Delivery {
        StandardDelivery(double weight, double distance) {
            super(weight, distance);
        }

        @Override
        String getType() {
            return "STANDARD";
        }

        @Override
        double calculateFee() {
            return 5 + 0.50 * getWeight() + 0.10 * getDistance();
        }
    }

    static class ExpressDelivery extends Delivery {
        ExpressDelivery(double weight, double distance) {
            super(weight, distance);
        }

        @Override
        String getType() {
            return "EXPRESS";
        }

        @Override
        double calculateFee() {
            return 15 + 1.00 * getWeight() + 0.20 * getDistance();
        }
    }

    static class InternationalDelivery extends Delivery {
        private final double customsFee;

        InternationalDelivery(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        @Override
        String getType() {
            return "INTERNATIONAL";
        }

        @Override
        double calculateFee() {
            return 25 + 2.00 * getWeight() + 0.50 * getDistance() + customsFee;
        }
    }

    static Delivery createDelivery(String[] tokens) {
        String type = tokens[0];
        double weight = Double.parseDouble(tokens[1]);
        double distance = Double.parseDouble(tokens[2]);
        switch (type) {
            case "STANDARD":
                return new StandardDelivery(weight, distance);
            case "EXPRESS":
                return new ExpressDelivery(weight, distance);
            case "INTERNATIONAL":
                return new InternationalDelivery(weight, distance, Double.parseDouble(tokens[3]));
            default:
                throw new IllegalArgumentException("Unknown delivery type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int requestCount = Integer.parseInt(scanner.nextLine().trim());
        List<Delivery> deliveries = new ArrayList<>();
        while (deliveries.size() < requestCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            deliveries.add(createDelivery(line.split("\\s+")));
        }

        double total = 0;
        for (Delivery delivery : deliveries) {
            double fee = delivery.calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", delivery.getType(), fee);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
