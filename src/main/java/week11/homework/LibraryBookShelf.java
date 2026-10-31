package week11.homework;

import java.util.Arrays;

/**
 * Problem 3: The Library Book Shelf
 *
 * Insertion Sort — takes each book (from the second onward) and
 * slides it left into its correct position among the already-sorted
 * portion of the shelf.
 *
 * Time Complexity:  O(n²) worst/average, O(n) best (already sorted).
 * Space Complexity: O(1) — in-place shifts only.
 */
public class LibraryBookShelf {

    public static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int newBook = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > newBook) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = newBook;

            System.out.println("After placing " + newBook + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test 1 ---");
        shelf(new int[]{30, 10, 40, 20});

        System.out.println("--- Custom Test ---");
        shelf(new int[]{50, 20, 40, 10, 30});
    }
}
