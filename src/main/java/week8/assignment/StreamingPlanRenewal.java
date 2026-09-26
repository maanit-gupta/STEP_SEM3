package week8.assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamingPlanRenewal {

    abstract static class Subscription {
        private final String subscriberName;
        private final LocalDate startDate;

        Subscription(String subscriberName, LocalDate startDate) {
            this.subscriberName = subscriberName;
            this.startDate = startDate;
        }

        String getSubscriberName() {
            return subscriberName;
        }

        abstract int getValidityDays();

        LocalDate calculateRenewalDate() {
            return startDate.plusDays(getValidityDays());
        }
    }

    static class BasicPlan extends Subscription {
        BasicPlan(String subscriberName, LocalDate startDate) {
            super(subscriberName, startDate);
        }

        @Override
        int getValidityDays() {
            return 30;
        }
    }

    static class StandardPlan extends Subscription {
        StandardPlan(String subscriberName, LocalDate startDate) {
            super(subscriberName, startDate);
        }

        @Override
        int getValidityDays() {
            return 90;
        }
    }

    static class PremiumPlan extends Subscription {
        PremiumPlan(String subscriberName, LocalDate startDate) {
            super(subscriberName, startDate);
        }

        @Override
        int getValidityDays() {
            return 365;
        }
    }

    static Subscription createSubscription(String type, String subscriberName, LocalDate startDate) {
        switch (type) {
            case "BASIC":
                return new BasicPlan(subscriberName, startDate);
            case "STANDARD":
                return new StandardPlan(subscriberName, startDate);
            case "PREMIUM":
                return new PremiumPlan(subscriberName, startDate);
            default:
                throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int subscriberCount = scanner.nextInt();
        List<Subscription> subscriptions = new ArrayList<>();
        for (int i = 0; i < subscriberCount; i++) {
            String type = scanner.next();
            String subscriberName = scanner.next();
            LocalDate startDate = LocalDate.parse(scanner.next());
            subscriptions.add(createSubscription(type, subscriberName, startDate));
        }

        for (Subscription subscription : subscriptions) {
            System.out.println(subscription.getSubscriberName() + ": " + subscription.calculateRenewalDate());
        }
        scanner.close();
    }
}
