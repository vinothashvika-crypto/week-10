import java.util.Arrays;

/**
 * Week 10 Assignment - Problem 4: Exam Score Band Counter
 * Counts scores s with low <= s <= high in a SORTED array using two binary searches.
 *
 * Complexity:
 *   Linear scan: O(n) time, O(1) space.
 *   This solution: O(log n) time (two binary searches), O(1) extra space.
 *
 * Duplicates: a normal binary search stops at ANY matching element. With repeated marks at the
 * edges of the band, we must find the FIRST index with score >= low (lower bound) and the FIRST
 * index with score > high (upper bound). Count = upperBound - lowerBound.
 */
public class A04_ExamScoreBandCounter {

    // First index whose value is >= target (or scores.length if none)
    static int lowerBound(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // First index whose value is > target (or scores.length if none)
    static int upperBound(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        return upperBound(scores, high) - lowerBound(scores, low);
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println("scores = " + Arrays.toString(scores));
        System.out.println("low = 42, high = 58 -> " + countInBand(scores, 42, 58));
        System.out.println("low = 90, high = 100 -> " + countInBand(scores, 90, 100));
    }
}
