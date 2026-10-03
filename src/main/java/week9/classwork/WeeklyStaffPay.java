package week9.classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeeklyStaffPay {

    abstract static class StaffMember {
        private final String name;

        StaffMember(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        abstract double calculatePay();
    }

    static class FullTimeStaff extends StaffMember {
        private final double weeklySalary;

        FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override
        double calculatePay() {
            return weeklySalary;
        }
    }

    static class HourlyStaff extends StaffMember {
        private static final double REGULAR_HOURS = 40;
        private static final double OVERTIME_MULTIPLIER = 1.5;

        private final double hours;
        private final double rate;

        HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        double calculatePay() {
            if (hours <= REGULAR_HOURS) {
                return hours * rate;
            }
            return REGULAR_HOURS * rate + (hours - REGULAR_HOURS) * rate * OVERTIME_MULTIPLIER;
        }
    }

    static class Intern extends StaffMember {
        private final double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        double calculatePay() {
            return stipend;
        }
    }

    static StaffMember createStaffMember(String[] tokens) {
        String type = tokens[0];
        String name = tokens[1];
        switch (type) {
            case "FULLTIME":
                return new FullTimeStaff(name, Double.parseDouble(tokens[2]));
            case "HOURLY":
                return new HourlyStaff(name, Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            case "INTERN":
                return new Intern(name, Double.parseDouble(tokens[2]));
            default:
                throw new IllegalArgumentException("Unknown staff type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int staffCount = Integer.parseInt(scanner.nextLine().trim());
        List<StaffMember> staffMembers = new ArrayList<>();
        while (staffMembers.size() < staffCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            staffMembers.add(createStaffMember(line.split("\\s+")));
        }

        double totalPayroll = 0;
        for (StaffMember staffMember : staffMembers) {
            double pay = staffMember.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f%n", staffMember.getName(), pay);
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        scanner.close();
    }
}
