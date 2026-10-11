package week10.classwork;

import java.util.Scanner;

public class EvenAndOddNumbersInList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            line = line.replace("[", "").replace("]", "").trim();
            if (!line.isEmpty()) {
                String[] tokens = line.split("[,\\s]+");
                int even = 0;
                int odd = 0;

                for (String token : tokens) {
                    if (!token.trim().isEmpty()) {
                        int num = Integer.parseInt(token.trim());
                        if (num % 2 == 0) {
                            even++;
                        } else {
                            odd++;
                        }
                    }
                }

                System.out.println("Even: " + even);
                System.out.println("Odd: " + odd);
            }
        }
        scanner.close();
    }
}
