package week10.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RotateRoster {

    public static String[] rotateRoster(String[] names, long k) {
        if (names == null || names.length == 0) {
            return names;
        }

        int n = names.length;
        int shift = (int) (k % n);
        if (shift < 0) {
            shift += n;
        }

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            Pattern pattern = Pattern.compile("\\[([^\\]]+)\\](?:.*k\\s*=\\s*(\\d+)|\\s+(\\d+))?");
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String arrayPart = matcher.group(1).trim();
                String kStr = matcher.group(2) != null ? matcher.group(2) : matcher.group(3);
                long k = 0;
                if (kStr != null) {
                    k = Long.parseLong(kStr.trim());
                } else if (scanner.hasNextLong()) {
                    k = scanner.nextLong();
                }

                String[] rawTokens = arrayPart.split("[,\\s]+");
                List<String> namesList = new ArrayList<>();
                for (String t : rawTokens) {
                    if (!t.trim().isEmpty()) {
                        namesList.add(t.trim());
                    }
                }

                String[] names = namesList.toArray(new String[0]);
                String[] result = rotateRoster(names, k);
                System.out.println(Arrays.toString(result));
            }
        }
        scanner.close();
    }
}
