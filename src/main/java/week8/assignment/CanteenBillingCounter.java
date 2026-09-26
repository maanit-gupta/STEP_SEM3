package week8.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CanteenBillingCounter {

    abstract static class Customer {
        private final double billAmount;

        Customer(double billAmount) {
            this.billAmount = billAmount;
        }

        double getBillAmount() {
            return billAmount;
        }

        abstract String getType();

        abstract double calculateFinalAmount();
    }

    static class Student extends Customer {
        Student(double billAmount) {
            super(billAmount);
        }

        @Override
        String getType() {
            return "STUDENT";
        }

        @Override
        double calculateFinalAmount() {
            return getBillAmount() * 0.90;
        }
    }

    static class Staff extends Customer {
        Staff(double billAmount) {
            super(billAmount);
        }

        @Override
        String getType() {
            return "STAFF";
        }

        @Override
        double calculateFinalAmount() {
            return getBillAmount() * 0.95;
        }
    }

    static class Guest extends Customer {
        Guest(double billAmount) {
            super(billAmount);
        }

        @Override
        String getType() {
            return "GUEST";
        }

        @Override
        double calculateFinalAmount() {
            return getBillAmount() + 10;
        }
    }

    static Customer createCustomer(String type, double billAmount) {
        switch (type) {
            case "STUDENT":
                return new Student(billAmount);
            case "STAFF":
                return new Staff(billAmount);
            case "GUEST":
                return new Guest(billAmount);
            default:
                throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int billCount = scanner.nextInt();
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < billCount; i++) {
            String type = scanner.next();
            double billAmount = scanner.nextDouble();
            customers.add(createCustomer(type, billAmount));
        }

        double total = 0;
        for (Customer customer : customers) {
            double finalAmount = customer.calculateFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", customer.getType(), finalAmount);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
