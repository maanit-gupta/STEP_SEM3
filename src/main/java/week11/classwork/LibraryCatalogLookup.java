package week11.classwork;

import java.util.Scanner;

/**
 * Problem 1: Library Catalog Lookup
 *
 * Uses binary search to find a book title by ISBN in a sorted catalog.
 *
 * Time Complexity:  O(log n) — binary search on sorted catalog.
 * Space Complexity: O(1) — only a few index variables.
 *
 * Binary search is appropriate because:
 * - The catalog is already sorted by ISBN.
 * - Queries vastly outnumber updates, so no re-sorting overhead per query.
 * - O(log n) per lookup beats O(n) linear scan at scale.
 */
public class LibraryCatalogLookup {

    public static String findBook(String[][] catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = catalog[mid][0].compareTo(targetIsbn);

            if (cmp == 0) {
                return catalog[mid][1];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        String[][] catalog = {
            {"0001112223", "Introduction to Algebra"},
            {"0002223334", "Beginning Python"},
            {"0003334445", "Classic Mythology"},
            {"0004445556", "Data and Society"},
            {"0005556667", "European History"}
        };

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            System.out.println(findBook(catalog, line));
        }
        scanner.close();
    }
}
