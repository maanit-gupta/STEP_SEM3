package week10.classwork;

import java.util.Scanner;

public class PrimeNumberChecker {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (isPrime(num)) {
                System.out.println(num + " is prime");
            } else {
                System.out.println(num + " is not prime");
            }
        }
        scanner.close();
    }
}
