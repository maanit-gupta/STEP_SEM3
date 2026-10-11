package week10.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondHighestScore {

    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }

        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            Pattern pattern = Pattern.compile("\\[([^\\]]+)\\]");
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String arrayPart = matcher.group(1).trim();
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

                System.out.println(secondHighest(scores));
            } else {

                String[] tokens = line.split("[,\\s]+");
                List<Integer> list = new ArrayList<>();
                for (String t : tokens) {
                    try {
                        list.add(Integer.parseInt(t.trim()));
                    } catch (NumberFormatException ignored) {
                    }
                }
                if (!list.isEmpty()) {
                    int[] scores = new int[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        scores[i] = list.get(i);
                    }
                    System.out.println(secondHighest(scores));
                }
            }
        }
        scanner.close();
    }
}
