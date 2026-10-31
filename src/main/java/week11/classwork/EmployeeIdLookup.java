package week11.classwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem 4: Employee ID Lookup in an Unsorted Directory
 *
 * Builds a HashMap from the unordered employee records for O(1) average
 * department lookups. This is appropriate because:
 * - Queries (dozens/day) vastly outnumber updates (a few/month).
 * - The one-time O(n) build cost is amortized over many fast lookups.
 *
 * getDepartment time complexity:  O(1) average (HashMap lookup).
 * buildLookup time complexity:    O(n) — single pass to populate the map.
 * Space complexity:               O(n) — the HashMap stores all n records.
 */
public class EmployeeIdLookup {

    public static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        String[][] records = {
            {"E245", "Finance"},
            {"E110", "Engineering"},
            {"E390", "Marketing"},
            {"E101", "Engineering"}
        };

        Map<String, String> lookup = buildLookup(records);

        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}
