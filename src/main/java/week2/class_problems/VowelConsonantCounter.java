package week2.class_problems;

import java.util.Scanner;

public class VowelConsonantCounter {

    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels +
                " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        countVowelsAndConsonants(text);

        scanner.close();
    }
}