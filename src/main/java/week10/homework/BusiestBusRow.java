package week10.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BusiestBusRow {

    public static int[] busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new int[]{-1, 0};
        }

        int bestRow = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < grid[i].length; j++) {
                currentTotal += grid[i][j];
            }

            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestRow = i;
            }
        }

        return new int[]{bestRow, maxTotal};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                sb.append(line).append(" ");
            }
        }
        scanner.close();

        String input = sb.toString().trim();
        if (input.isEmpty()) {
            return;
        }

        List<int[]> rowsList = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\[([0-9,\\s]+)\\]");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String rowContent = matcher.group(1).trim();
            String[] tokens = rowContent.split("[,\\s]+");
            List<Integer> rowNums = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    rowNums.add(Integer.parseInt(token));
                }
            }
            int[] rowArr = new int[rowNums.size()];
            for (int i = 0; i < rowNums.size(); i++) {
                rowArr[i] = rowNums.get(i);
            }
            rowsList.add(rowArr);
        }

        if (rowsList.isEmpty()) {
            String[] tokens = input.replaceAll("[^0-9\\s]", " ").trim().split("\\s+");
            if (tokens.length >= 2) {
                int r = Integer.parseInt(tokens[0]);
                int c = Integer.parseInt(tokens[1]);
                int idx = 2;
                for (int i = 0; i < r && idx < tokens.length; i++) {
                    int[] rowArr = new int[c];
                    for (int j = 0; j < c && idx < tokens.length; j++) {
                        rowArr[j] = Integer.parseInt(tokens[idx++]);
                    }
                    rowsList.add(rowArr);
                }
            }
        }

        int[][] grid = rowsList.toArray(new int[0][]);
        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
