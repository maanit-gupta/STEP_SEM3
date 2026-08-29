package week1.assigment_problems;

public class TypingSpeedTestAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {

        int matchedCharacters = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy =
                ((double) matchedCharacters / original.length()) * 100;

        System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%%",
                matchedCharacters,
                original.length(),
                accuracy
        );

        if (firstMismatch == -1) {

            System.out.println(" | No Mismatches");

        } else {

            System.out.println(
                    " | First Mismatch at position "
                            + (firstMismatch + 1)
                            + " ('"
                            + original.charAt(firstMismatch)
                            + "' vs '"
                            + typed.charAt(firstMismatch)
                            + "')"
            );
        }
    }

    public static void main(String[] args) {

        String original = "hello world";
        String typed = "hello worlt";

        checkTypingAccuracy(original, typed);
    }
}