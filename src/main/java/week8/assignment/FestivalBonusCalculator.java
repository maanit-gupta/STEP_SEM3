package week8.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FestivalBonusCalculator {

    abstract static class Employee {
        private final String name;
        private final double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        String getName() {
            return name;
        }

        double getMonthlySalary() {
            return monthlySalary;
        }

        abstract double calculateBonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        double calculateBonus() {
            return getMonthlySalary() * 0.10;
        }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        double calculateBonus() {
            return getMonthlySalary() * 0.05;
        }
    }

    static class Intern extends Employee {
        Intern(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        double calculateBonus() {
            return 2000;
        }
    }

    static Employee createEmployee(String type, String name, double monthlySalary) {
        switch (type) {
            case "FULLTIME":
                return new FullTimeEmployee(name, monthlySalary);
            case "PARTTIME":
                return new PartTimeEmployee(name, monthlySalary);
            case "INTERN":
                return new Intern(name, monthlySalary);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeCount = scanner.nextInt();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < employeeCount; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double monthlySalary = scanner.nextDouble();
            employees.add(createEmployee(type, name, monthlySalary));
        }

        double totalBonus = 0;
        for (Employee employee : employees) {
            double bonus = employee.calculateBonus();
            totalBonus += bonus;
            System.out.printf("%s: %.2f%n", employee.getName(), bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", totalBonus);
        scanner.close();
    }
}
