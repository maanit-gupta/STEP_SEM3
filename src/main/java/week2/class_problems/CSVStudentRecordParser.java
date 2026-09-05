package week2.class_problems;

import java.util.Scanner;

public class CSVStudentRecordParser {

    public static void parseStudentRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println(
                "Name: " + fields[0] +
                " | Roll No: " + fields[1] +
                " | Dept: " + fields[2]
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student record: ");
        String record = scanner.nextLine();

        parseStudentRecord(record);

        scanner.close();
    }
}