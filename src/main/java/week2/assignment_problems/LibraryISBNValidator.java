package week2.assignment_problems;

import java.util.Scanner;

public class LibraryISBNValidator {

    public static String normalizeCode(String raw) {

        String code = raw.trim();

        if (code.length() < 3) {
            return code;
        }

        return code.substring(0, 3).toUpperCase()
                + code.substring(3);
    }

    public static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder result = new StringBuilder();

        result.append("[")
                .append(code.substring(0, 3))
                .append("] YEAR: ")
                .append(year)
                .append(" | CATALOG: ")
                .append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ISBN-style code: ");
        String raw = scanner.nextLine();

        String code = normalizeCode(raw);

        System.out.println(validateAndFormat(code));

        scanner.close();
    }
}