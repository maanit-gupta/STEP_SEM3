package week8.classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentSystem {

    abstract static class Payment {
        private final double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        double getAmount() {
            return amount;
        }

        abstract String getType();

        abstract double calculateFinalAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) {
            super(amount);
        }

        @Override
        String getType() {
            return "CARD";
        }

        @Override
        double calculateFinalAmount() {
            return getAmount() * 1.02;
        }
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) {
            super(amount);
        }

        @Override
        String getType() {
            return "WALLET";
        }

        @Override
        double calculateFinalAmount() {
            return getAmount() * 1.01;
        }
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) {
            super(amount);
        }

        @Override
        String getType() {
            return "BANKTRANSFER";
        }

        @Override
        double calculateFinalAmount() {
            return getAmount();
        }
    }

    static Payment createPayment(String type, double amount) {
        switch (type) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            case "BANKTRANSFER":
                return new BankTransferPayment(amount);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int transactionCount = scanner.nextInt();
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < transactionCount; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            payments.add(createPayment(type, amount));
        }

        double total = 0;
        for (Payment payment : payments) {
            double finalAmount = payment.calculateFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", payment.getType(), finalAmount);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
