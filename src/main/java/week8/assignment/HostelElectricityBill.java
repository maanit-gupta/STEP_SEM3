package week8.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HostelElectricityBill {

    abstract static class Room {
        private final int units;

        Room(int units) {
            this.units = units;
        }

        int getUnits() {
            return units;
        }

        abstract String getType();

        abstract double calculateBill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) {
            super(units);
        }

        @Override
        String getType() {
            return "SINGLE";
        }

        @Override
        double calculateBill() {
            return 8.0 * getUnits();
        }
    }

    static class SharedRoom extends Room {
        private final int occupants;

        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override
        String getType() {
            return "SHARED";
        }

        @Override
        double calculateBill() {
            return 6.0 * getUnits() / occupants;
        }
    }

    static class AcRoom extends Room {
        AcRoom(int units) {
            super(units);
        }

        @Override
        String getType() {
            return "AC";
        }

        @Override
        double calculateBill() {
            return 10.0 * getUnits() + 200;
        }
    }

    static Room createRoom(String[] tokens) {
        String type = tokens[0];
        int units = Integer.parseInt(tokens[1]);
        switch (type) {
            case "SINGLE":
                return new SingleRoom(units);
            case "SHARED":
                return new SharedRoom(units, Integer.parseInt(tokens[2]));
            case "AC":
                return new AcRoom(units);
            default:
                throw new IllegalArgumentException("Unknown room type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roomCount = Integer.parseInt(scanner.nextLine().trim());
        List<Room> rooms = new ArrayList<>();
        while (rooms.size() < roomCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            rooms.add(createRoom(line.split("\\s+")));
        }

        double total = 0;
        for (Room room : rooms) {
            double bill = room.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", room.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
