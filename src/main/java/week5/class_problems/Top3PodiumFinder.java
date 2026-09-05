package week5.class_problems;

import java.util.Arrays;

public class Top3PodiumFinder {

    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            return new int[]{};
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i < scores.length; i++) {
            int s = scores[i];

            if (s >= first) {
                third = second;
                second = first;
                first = s;
            } else if (s >= second) {
                third = second;
                second = s;
            } else if (s >= third) {
                third = s;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(Arrays.toString(findTopThreeScores(scores)));
    }
}
