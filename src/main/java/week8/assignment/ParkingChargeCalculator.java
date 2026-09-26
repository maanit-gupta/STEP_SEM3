package week8.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingChargeCalculator {

    abstract static class Vehicle {
        private final int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        int getHours() {
            return hours;
        }

        abstract String getType();

        abstract double calculateCharge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) {
            super(hours);
        }

        @Override
        String getType() {
            return "BIKE";
        }

        @Override
        double calculateCharge() {
            return 10.0 * getHours();
        }
    }

    static class Car extends Vehicle {
        Car(int hours) {
            super(hours);
        }

        @Override
        String getType() {
            return "CAR";
        }

        @Override
        double calculateCharge() {
            return 30.0 + 20.0 * (getHours() - 1);
        }
    }

    static class Truck extends Vehicle {
        Truck(int hours) {
            super(hours);
        }

        @Override
        String getType() {
            return "TRUCK";
        }

        @Override
        double calculateCharge() {
            return Math.max(50.0 * getHours(), 100.0);
        }
    }

    static Vehicle createVehicle(String type, int hours) {
        switch (type) {
            case "BIKE":
                return new Bike(hours);
            case "CAR":
                return new Car(hours);
            case "TRUCK":
                return new Truck(hours);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vehicleCount = scanner.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < vehicleCount; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            vehicles.add(createVehicle(type, hours));
        }

        double total = 0;
        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();
            total += charge;
            System.out.printf("%s: %.2f%n", vehicle.getType(), charge);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
