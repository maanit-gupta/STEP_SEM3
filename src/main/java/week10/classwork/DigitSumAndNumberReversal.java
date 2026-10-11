package week10.classwork;

import java.util.Scanner;

public class DigitSumAndNumberReversal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int temp = num;
            int sumOfDigits = 0;
            int reversed = 0;

            while (temp > 0) {
                int digit = temp % 10;
                sumOfDigits += digit;
                reversed = reversed * 10 + digit;
                temp /= 10;
            }

            System.out.println("Sum of digits: " + sumOfDigits);
            System.out.println("Reverse: " + reversed);
        }
        scanner.close();
    }
}
