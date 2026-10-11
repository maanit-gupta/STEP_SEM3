package week10.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendanceSummary {

    public static int[] attendanceSummary(int[] days) {
        if (days == null || days.length == 0) {
            return new int[]{0, 0};
        }

        int totalPresent = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                totalPresent++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new int[]{totalPresent, longestStreak};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String cleaned = line.replaceAll(".*=", "").replace("[", "").replace("]", "").trim();
            if (cleaned.isEmpty()) {
                continue;
            }

            String[] tokens = cleaned.split("[,\\s]+");
            List<Integer> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.trim().isEmpty()) {
                    list.add(Integer.parseInt(token.trim()));
                }
            }

            int[] days = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                days[i] = list.get(i);
            }

            int[] summary = attendanceSummary(days);
            System.out.printf("Present: %d, Longest streak: %d%n", summary[0], summary[1]);
        }
        scanner.close();
    }
}
