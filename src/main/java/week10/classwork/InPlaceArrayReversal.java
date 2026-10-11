package week10.classwork;

import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {

    public static void reverseInPlace(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            line = line.replace("[", "").replace("]", "").trim();
            if (!line.isEmpty()) {
                String[] tokens = line.split("[,\\s]+");
                int[] arr = new int[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    arr[i] = Integer.parseInt(tokens[i].trim());
                }

                reverseInPlace(arr);

                System.out.println(Arrays.toString(arr));
            }
        }
        scanner.close();
    }
}
