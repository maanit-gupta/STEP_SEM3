package week9.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParcelShippingDesk {

    interface Insurable {
        double INSURANCE_RATE = 0.02;

        double getDeclaredValue();

        default double calculateInsurance() {
            return getDeclaredValue() * INSURANCE_RATE;
        }
    }

    abstract static class Parcel {
        private final double weightKg;
        private final double declaredValue;

        Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        double getWeightKg() {
            return weightKg;
        }

        public double getDeclaredValue() {
            return declaredValue;
        }

        abstract String getType();

        abstract double calculateCharge();
    }

    static class StandardParcel extends Parcel {
        StandardParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        String getType() {
            return "STANDARD";
        }

        @Override
        double calculateCharge() {
            return 40 + 10.0 * getWeightKg();
        }
    }

    static class ExpressParcel extends Parcel implements Insurable {
        ExpressParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        String getType() {
            return "EXPRESS";
        }

        @Override
        double calculateCharge() {
            return 80 + 15.0 * getWeightKg();
        }
    }

    static class FragileParcel extends StandardParcel implements Insurable {
        private static final double HANDLING_FEE = 50;

        FragileParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        String getType() {
            return "FRAGILE";
        }

        @Override
        double calculateCharge() {
            return super.calculateCharge() + HANDLING_FEE;
        }
    }

    static Parcel createParcel(String[] tokens) {
        String type = tokens[0];
        double weightKg = Double.parseDouble(tokens[1]);
        double declaredValue = Double.parseDouble(tokens[2]);
        switch (type) {
            case "STANDARD":
                return new StandardParcel(weightKg, declaredValue);
            case "EXPRESS":
                return new ExpressParcel(weightKg, declaredValue);
            case "FRAGILE":
                return new FragileParcel(weightKg, declaredValue);
            default:
                throw new IllegalArgumentException("Unknown parcel type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int parcelCount = Integer.parseInt(scanner.nextLine().trim());
        List<Parcel> parcels = new ArrayList<>();
        while (parcels.size() < parcelCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            parcels.add(createParcel(line.split("\\s+")));
        }

        double grandTotal = 0;
        for (Parcel parcel : parcels) {
            double charge = parcel.calculateCharge();
            double insurance = parcel instanceof Insurable insurable ? insurable.calculateInsurance() : 0;
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", parcel.getType(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
