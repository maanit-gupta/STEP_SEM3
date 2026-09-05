package week1.class_problems;

import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(
            text.substring(1, text.length() - 1)
        );
    }

    public static boolean isPalindromeArrayReversal(String text) {

        char[] characters = text.toCharArray();
        char[] reversed = new char[characters.length];

        for (int i = 0; i < characters.length; i++) {
            reversed[i] = characters[characters.length - 1 - i];
        }

        String reversedText = new String(reversed);

        return text.equals(reversedText);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        if (isPalindromeIterative(text)) {
            System.out.println("Iterative: Palindrome");
        } else {
            System.out.println("Iterative: Not Palindrome");
        }

        if (isPalindromeRecursive(text)) {
            System.out.println("Recursive: Palindrome");
        } else {
            System.out.println("Recursive: Not Palindrome");
        }

        if (isPalindromeArrayReversal(text)) {
            System.out.println("Array Reversal: Palindrome");
        } else {
            System.out.println("Array Reversal: Not Palindrome");
        }

        scanner.close();
    }
}