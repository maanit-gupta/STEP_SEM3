package week5.class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PlacementDriveShortlistingRankingEngine {

    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return isEligible(cgpa) || (cgpa >= 6.5 && codingScore >= 60);
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> shortlisted = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            Candidate candidate = candidates[i];
            if (candidate != null && (isEligible(candidate.cgpa) || isEligible(candidate.cgpa, candidate.codingScore))) {
                shortlisted.add(candidate);
            }
        }

        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shortlistedArray.length; i++) {
            Candidate c = shortlistedArray[i];
            result.append(i + 1)
                  .append(". ")
                  .append(c.name)
                  .append(" (")
                  .append(String.format(Locale.US, "%.1f", c.compositeScore))
                  .append(")");

            if (i < shortlistedArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}

class Candidate implements Comparable<Candidate> {

    String name;
    double cgpa;
    int codingScore;
    double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        this.compositeScore = 10 * cgpa + 0.5 * codingScore;
    }

    public static boolean isEligible(double cgpa) {
        return PlacementDriveShortlistingRankingEngine.isEligible(cgpa);
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return PlacementDriveShortlistingRankingEngine.isEligible(cgpa, codingScore);
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        return PlacementDriveShortlistingRankingEngine.shortlistAndRank(candidates);
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore, this.compositeScore);
    }
}
