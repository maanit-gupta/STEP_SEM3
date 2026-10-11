package week10.classwork;

import java.util.Scanner;

public class LeapYearDetector {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int year = scanner.nextInt();
            if (isLeapYear(year)) {
                System.out.println("Leap year");
            } else {
                System.out.println("Not a leap year");
            }
        }
        scanner.close();
    }
}
