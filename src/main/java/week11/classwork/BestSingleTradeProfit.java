package week11.classwork;

/**
 * Problem 6: Best Single Trade Profit
 *
 * Single-pass approach:
 *   Time Complexity:  O(n) — scans the array once.
 *   Space Complexity: O(1) — two tracking variables.
 *
 * Brute-force (every pair of days):
 *   Time Complexity:  O(n²) — nested loops.
 *   Space Complexity: O(1).
 *
 * The single-pass O(n) solution is preferable at scale because
 * it avoids the quadratic blowup of checking every buy/sell pair,
 * which becomes impractical for large price histories.
 */
public class BestSingleTradeProfit {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2));
    }
}
