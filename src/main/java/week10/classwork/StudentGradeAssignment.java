package week10.classwork;

import java.util.Scanner;

public class StudentGradeAssignment {

    public static String assignGrade(int marks) {
        if (marks >= 90) {
            return "Grade A";
        } else if (marks >= 75) {
            return "Grade B";
        } else if (marks >= 60) {
            return "Grade C";
        } else if (marks >= 40) {
            return "Grade D";
        } else {
            return "Grade F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int marks = scanner.nextInt();
            System.out.println(assignGrade(marks));
        }
        scanner.close();
    }
}
