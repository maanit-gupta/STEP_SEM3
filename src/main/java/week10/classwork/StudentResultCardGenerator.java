package week10.classwork;

import java.util.Locale;
import java.util.Scanner;

public class StudentResultCardGenerator {

    static class Student {
        private final String name;
        private final int[] marks;

        public Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        public double calculateAverage() {
            int sum = 0;
            for (int mark : marks) {
                sum += mark;
            }
            return (double) sum / marks.length;
        }

        public char assignGrade() {
            double avg = calculateAverage();
            if (avg >= 90.0) {
                return 'A';
            } else if (avg >= 75.0) {
                return 'B';
            } else if (avg >= 60.0) {
                return 'C';
            } else if (avg >= 40.0) {
                return 'D';
            } else {
                return 'F';
            }
        }

        public void printResultCard() {
            System.out.printf(Locale.US, "%s: Average %.1f, Grade %c%n",
                    name.toUpperCase(), calculateAverage(), assignGrade());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String cleaned = line.replace("[", " ").replace("]", " ").replace(",", " ");
            String[] tokens = cleaned.trim().split("\\s+");
            if (tokens.length >= 4) {
                String name = tokens[0];
                int[] marks = new int[tokens.length - 1];
                for (int i = 1; i < tokens.length; i++) {
                    marks[i - 1] = Integer.parseInt(tokens[i]);
                }
                Student student = new Student(name, marks);
                student.printResultCard();
            }
        }
        scanner.close();
    }
}
