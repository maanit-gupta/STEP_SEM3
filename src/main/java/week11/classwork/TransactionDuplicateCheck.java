package week11.classwork;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem 3: Transaction Duplicate Check
 *
 * Checks whether any transaction ID appears more than once using a HashSet.
 *
 * Chosen approach — HashSet:
 *   Time Complexity:  O(n) — single pass with O(1) average HashSet lookup.
 *   Space Complexity: O(n) — stores up to n IDs in the set.
 *
 * Alternative approach — Sort then linear scan:
 *   Time Complexity:  O(n log n) — dominated by sorting.
 *   Space Complexity: O(1) additional (in-place sort) or O(n) (merge sort).
 *   Trade-off: uses less memory but takes longer; unsuitable when millions
 *   of transactions must be processed nightly and speed is the priority.
 */
public class TransactionDuplicateCheck {

    public static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] batch1 = {"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"};
        String[] batch2 = {"TXN2001", "TXN2002", "TXN2003"};

        System.out.println(hasDuplicate(batch1));
        System.out.println(hasDuplicate(batch2));
    }
}
