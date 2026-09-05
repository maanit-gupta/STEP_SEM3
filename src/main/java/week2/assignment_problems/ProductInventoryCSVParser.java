package week2.assignment_problems;

import java.util.Scanner;

public class ProductInventoryCSVParser {

    public static void parseInventoryRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println(
                "Product: " + fields[0] +
                " | SKU: " + fields[1] +
                " | Qty: " + fields[2]
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter inventory record: ");
        String record = scanner.nextLine();

        parseInventoryRecord(record);

        scanner.close();
    }
}