import java.util.Arrays;

/**
 * Week 10 Assignment - Problem 7: Second-Best Score (second-highest DISTINCT score, no sorting)
 *
 * Complexity: O(n) time, O(1) extra space.
 * Sorting first would cost O(n log n) time (and O(n) extra space if we don't want to change the input).
 */
public class A07_SecondBestScore {

    static int secondHighest(int[] scores) {
        int highest = -1, second = -1;   // scores are 0..100, so -1 means "none yet"
        for (int score : scores) {
            if (score == highest) continue;          // skip repeats of the current highest
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score > second) {
                second = score;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[][] samples = {{45, 78, 92, 78, 60}, {50, 50, 50}};
        for (int[] scores : samples) {
            System.out.println("scores = " + Arrays.toString(scores) + " -> " + secondHighest(scores));
        }
    }
}
