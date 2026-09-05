package week2.class_problems;

import java.util.Scanner;

public class BankTransactionReferenceValidator {

    public static String normalizeReference(String raw) {

        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference;
        }

        return reference.substring(0, 3).toUpperCase()
                + reference.substring(3);
    }

    public static String validateAndFormat(String reference) {

        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: reference body must contain only digits";
            }
        }

        String bankCode = reference.substring(0, 3);

        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);

        String sequence = reference.substring(9);

        StringBuilder result = new StringBuilder();

        result.append("[")
                .append(bankCode)
                .append("] DATE: ")
                .append(day)
                .append("/")
                .append(month)
                .append("/")
                .append(year)
                .append(" | SEQ: ")
                .append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = scanner.nextLine();

        String reference = normalizeReference(raw);

        System.out.println(validateAndFormat(reference));

        scanner.close();
    }
}
