package control_flow.assigment_problems;

import java.util.Scanner;

public class PrintNumbersUpToN {

    static void printNumbersUpToN(int n) {

        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        printNumbersUpToN(n);

        sc.close();
    }
}