package week9.classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GardenPlotAreaReport {

    abstract static class Plot {
        private final String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        String getOwner() {
            return owner;
        }

        abstract String getShape();

        abstract double calculateArea();
    }

    static class CirclePlot extends Plot {
        private final double radius;

        CirclePlot(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        @Override
        String getShape() {
            return "CIRCLE";
        }

        @Override
        double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    static class RectanglePlot extends Plot {
        private final double length;
        private final double width;

        RectanglePlot(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        @Override
        String getShape() {
            return "RECTANGLE";
        }

        @Override
        double calculateArea() {
            return length * width;
        }
    }

    static class TrianglePlot extends Plot {
        private final double base;
        private final double height;

        TrianglePlot(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        @Override
        String getShape() {
            return "TRIANGLE";
        }

        @Override
        double calculateArea() {
            return 0.5 * base * height;
        }
    }

    static Plot createPlot(String[] tokens) {
        String shape = tokens[0];
        String owner = tokens[1];
        switch (shape) {
            case "CIRCLE":
                return new CirclePlot(owner, Double.parseDouble(tokens[2]));
            case "RECTANGLE":
                return new RectanglePlot(owner, Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            case "TRIANGLE":
                return new TrianglePlot(owner, Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            default:
                throw new IllegalArgumentException("Unknown plot shape: " + shape);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plotCount = Integer.parseInt(scanner.nextLine().trim());
        List<Plot> plots = new ArrayList<>();
        while (plots.size() < plotCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            plots.add(createPlot(line.split("\\s+")));
        }

        double totalArea = 0;
        for (Plot plot : plots) {
            double area = plot.calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f%n", plot.getOwner(), plot.getShape(), area);
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
        scanner.close();
    }
}
