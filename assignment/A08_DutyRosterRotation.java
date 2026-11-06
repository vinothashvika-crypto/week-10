import java.util.Arrays;

/**
 * Week 10 Assignment - Problem 8: Duty Roster Rotation (rotate right by k, k can be huge)
 *
 * Complexity: O(n) time, O(n) space for the new roster.
 * Rotating one place at a time, k times, costs O(n * k). With k up to 10^9 that is billions of
 * moves - far too slow. Using k % n removes the full turns, so each name moves exactly once.
 */
public class A08_DutyRosterRotation {

    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        System.out.println("names = " + Arrays.toString(names) + ", k = 2 -> " + Arrays.toString(rotateRoster(names, 2)));
        System.out.println("names = " + Arrays.toString(names) + ", k = 7 -> " + Arrays.toString(rotateRoster(names, 7)) + "  // 7 places is the same as 2");
    }
}
