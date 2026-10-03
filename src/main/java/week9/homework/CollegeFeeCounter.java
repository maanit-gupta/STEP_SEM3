package week9.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollegeFeeCounter {

    interface BusUser {
        double TRANSPORT_FEE = 12000;

        default double getTransportFee() {
            return TRANSPORT_FEE;
        }
    }

    abstract static class Student {
        static final double NORMAL_TUITION = 40000;

        private final String name;

        Student(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        abstract double calculateTuition();
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) {
            super(name);
        }

        @Override
        double calculateTuition() {
            return NORMAL_TUITION;
        }
    }

    static class Hosteller extends Student {
        private static final double HOSTEL_FEE = 60000;

        Hosteller(String name) {
            super(name);
        }

        @Override
        double calculateTuition() {
            return NORMAL_TUITION + HOSTEL_FEE;
        }
    }

    static class ScholarshipStudent extends Student implements BusUser {
        ScholarshipStudent(String name) {
            super(name);
        }

        @Override
        double calculateTuition() {
            return NORMAL_TUITION / 2;
        }
    }

    static Student createStudent(String[] tokens) {
        String type = tokens[0];
        String name = tokens[1];
        switch (type) {
            case "DAY_SCHOLAR":
                return new DayScholar(name);
            case "HOSTELLER":
                return new Hosteller(name);
            case "SCHOLAR":
                return new ScholarshipStudent(name);
            default:
                throw new IllegalArgumentException("Unknown student type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCount = Integer.parseInt(scanner.nextLine().trim());
        List<Student> students = new ArrayList<>();
        while (students.size() < studentCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            students.add(createStudent(line.split("\\s+")));
        }

        double totalCollected = 0;
        for (Student student : students) {
            double fee = student.calculateTuition();
            if (student instanceof BusUser busUser) {
                fee += busUser.getTransportFee();
            }
            totalCollected += fee;
            System.out.printf("%s: %.2f%n", student.getName(), fee);
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
        scanner.close();
    }
}
