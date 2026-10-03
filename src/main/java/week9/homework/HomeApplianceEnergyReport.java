package week9.homework;

import java.util.Scanner;

public class HomeApplianceEnergyReport {

    interface SaverMode {
        double SAVER_REDUCTION = 0.25;

        default double applySaver(double units) {
            return units * (1 - SAVER_REDUCTION);
        }
    }

    abstract static class Appliance {
        private final double hours;

        Appliance(double hours) {
            this.hours = hours;
        }

        abstract String getType();

        abstract double getPowerWatts();

        final double calculateUnits() {
            return getPowerWatts() * hours / 1000;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double hours) {
            super(hours);
        }

        @Override
        String getType() {
            return "FRIDGE";
        }

        @Override
        double getPowerWatts() {
            return 150;
        }
    }

    static class AirConditioner extends Appliance implements SaverMode {
        AirConditioner(double hours) {
            super(hours);
        }

        @Override
        String getType() {
            return "AC";
        }

        @Override
        double getPowerWatts() {
            return 1500;
        }
    }

    static class Television extends Appliance {
        Television(double hours) {
            super(hours);
        }

        @Override
        String getType() {
            return "TV";
        }

        @Override
        double getPowerWatts() {
            return 100;
        }
    }

    static class WashingMachine extends Appliance implements SaverMode {
        WashingMachine(double hours) {
            super(hours);
        }

        @Override
        String getType() {
            return "WASHER";
        }

        @Override
        double getPowerWatts() {
            return 500;
        }
    }

    private static final double COST_PER_UNIT = 8;

    static Appliance createAppliance(String type, double hours) {
        switch (type) {
            case "FRIDGE":
                return new Fridge(hours);
            case "AC":
                return new AirConditioner(hours);
            case "TV":
                return new Television(hours);
            case "WASHER":
                return new WashingMachine(hours);
            default:
                throw new IllegalArgumentException("Unknown appliance type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int applianceCount = Integer.parseInt(scanner.nextLine().trim());
        double totalCost = 0;
        int processed = 0;
        while (processed < applianceCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            processed++;
            String[] tokens = line.split("\\s+");
            Appliance appliance = createAppliance(tokens[0], Double.parseDouble(tokens[1]));
            boolean saverRequested = tokens.length > 2 && tokens[2].equals("SAVER");
            double units = appliance.calculateUnits();
            if (saverRequested) {
                if (!(appliance instanceof SaverMode saverMode)) {
                    System.out.printf("%s: saver mode not supported%n", appliance.getType());
                    continue;
                }
                units = saverMode.applySaver(units);
            }
            double cost = units * COST_PER_UNIT;
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getType(), units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        scanner.close();
    }
}
