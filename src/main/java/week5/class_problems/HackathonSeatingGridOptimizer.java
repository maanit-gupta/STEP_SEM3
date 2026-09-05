package week5.class_problems;

public class HackathonSeatingGridOptimizer {

    public static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }

        return sum / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);
            String zone = (average >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            result.append("Row ").append(i).append(": ").append(zone);

            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;

        System.out.println(classifyRows(seatingScores, threshold));
    }
}
