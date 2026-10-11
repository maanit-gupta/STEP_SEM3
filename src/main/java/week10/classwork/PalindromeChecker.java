package week10.classwork;

import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String original = scanner.next();
            StringBuilder sb = new StringBuilder(original);
            String reversed = sb.reverse().toString();

            if (original.equalsIgnoreCase(reversed)) {
                System.out.println(reversed + " - palindrome");
            } else {
                System.out.println(reversed + " - not a palindrome");
            }
        }
        scanner.close();
    }
}
