package week9.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElectricityConnectionBilling {

    abstract static class Connection {
        private final int units;

        Connection(int units) {
            this.units = units;
        }

        int getUnits() {
            return units;
        }

        abstract String getType();

        abstract double calculateBill();
    }

    static class HomeConnection extends Connection {
        private static final int BASE_UNITS = 100;

        HomeConnection(int units) {
            super(units);
        }

        @Override
        String getType() {
            return "HOME";
        }

        @Override
        double calculateBill() {
            if (getUnits() <= BASE_UNITS) {
                return 5.0 * getUnits();
            }
            return 5.0 * BASE_UNITS + 7.0 * (getUnits() - BASE_UNITS);
        }
    }

    static class ShopConnection extends Connection {
        private static final double FIXED_CHARGE = 100;

        ShopConnection(int units) {
            super(units);
        }

        @Override
        String getType() {
            return "SHOP";
        }

        @Override
        double calculateBill() {
            return 8.0 * getUnits() + FIXED_CHARGE;
        }
    }

    static class FactoryConnection extends Connection {
        private static final double MINIMUM_BILL = 1000;

        FactoryConnection(int units) {
            super(units);
        }

        @Override
        String getType() {
            return "FACTORY";
        }

        @Override
        double calculateBill() {
            return Math.max(6.0 * getUnits(), MINIMUM_BILL);
        }
    }

    static Connection createConnection(String[] tokens) {
        String type = tokens[0];
        int units = Integer.parseInt(tokens[1]);
        switch (type) {
            case "HOME":
                return new HomeConnection(units);
            case "SHOP":
                return new ShopConnection(units);
            case "FACTORY":
                return new FactoryConnection(units);
            default:
                throw new IllegalArgumentException("Unknown connection type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int connectionCount = Integer.parseInt(scanner.nextLine().trim());
        List<Connection> connections = new ArrayList<>();
        while (connections.size() < connectionCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            connections.add(createConnection(line.split("\\s+")));
        }

        double total = 0;
        for (Connection connection : connections) {
            double bill = connection.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", connection.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
