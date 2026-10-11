package week10.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountInBand {

    public static int lowerBound(int[] scores, int target) {
        int low = 0;
        int high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upperBound(int[] scores, int target) {
        int low = 0;
        int high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }

        int start = lowerBound(scores, low);
        int end = upperBound(scores, high);

        return Math.max(0, end - start);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            Pattern arrayPattern = Pattern.compile("\\[([^\\]]+)\\]");
            Matcher arrayMatcher = arrayPattern.matcher(line);

            if (arrayMatcher.find()) {
                String arrayPart = arrayMatcher.group(1).trim();
                String[] tokens = arrayPart.split("[,\\s]+");
                List<Integer> list = new ArrayList<>();
                for (String t : tokens) {
                    if (!t.trim().isEmpty()) {
                        list.add(Integer.parseInt(t.trim()));
                    }
                }

                int[] scores = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    scores[i] = list.get(i);
                }

                int low = 0;
                int high = 100;

                Pattern lowPattern = Pattern.compile("low\\s*=\\s*(\\d+)");
                Matcher lowMatcher = lowPattern.matcher(line);
                if (lowMatcher.find()) {
                    low = Integer.parseInt(lowMatcher.group(1));
                }

                Pattern highPattern = Pattern.compile("high\\s*=\\s*(\\d+)");
                Matcher highMatcher = highPattern.matcher(line);
                if (highMatcher.find()) {
                    high = Integer.parseInt(highMatcher.group(1));
                }

                System.out.println(countInBand(scores, low, high));
            }
        }
        scanner.close();
    }
}
