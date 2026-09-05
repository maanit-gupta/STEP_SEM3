package week5.assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FantasyLeagueAutoDraftRankingEngine {

    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return isDraftable(matchesPlayed) || (!injured && matchesPlayed >= 5);
    }

    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftable = new ArrayList<>();

        for (int i = 0; i < players.length; i++) {
            Player p = players[i];
            if (p != null && (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured))) {
                draftable.add(p);
            }
        }

        Player[] draftableArray = draftable.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < draftableArray.length; i++) {
            result.append(i + 1)
                  .append(". ")
                  .append(draftableArray[i].name);

            if (i < draftableArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}

class Player implements Comparable<Player> {

    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public static boolean isDraftable(int matchesPlayed) {
        return FantasyLeagueAutoDraftRankingEngine.isDraftable(matchesPlayed);
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return FantasyLeagueAutoDraftRankingEngine.isDraftable(matchesPlayed, injured);
    }

    public static String draftAndRank(Player[] players) {
        return FantasyLeagueAutoDraftRankingEngine.draftAndRank(players);
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}
