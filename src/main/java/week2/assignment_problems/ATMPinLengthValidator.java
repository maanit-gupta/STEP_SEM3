package week2.assignment_problems;

import java.util.Scanner;

public class ATMPinLengthValidator {

    public static void checkPinLength(String pin) {

        if (pin.length() != 4) {
            System.out.println(
                    "Invalid PIN — must be exactly 4 digits."
            );
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        checkPinLength(pin);

        scanner.close();
    }
}