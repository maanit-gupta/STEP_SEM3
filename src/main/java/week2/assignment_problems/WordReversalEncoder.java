package week2.assignment_problems;

import java.util.Scanner;

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder word =
                    new StringBuilder(words[i]);

            result.append(word.reverse());

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String sentence = scanner.nextLine();

        System.out.println(reverseEachWord(sentence));

        scanner.close();
    }
}