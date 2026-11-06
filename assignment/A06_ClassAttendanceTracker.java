import java.util.Arrays;

/**
 * Week 10 Assignment - Problem 6: Class Attendance Tracker
 * Present days and the longest unbroken run of present days, both found in ONE pass.
 *
 * Complexity: O(n) time, O(1) extra space. Yes - both answers come from a single pass.
 */
public class A06_ClassAttendanceTracker {

    static int[] attendanceSummary(int[] days) {
        int present = 0, currentStreak = 0, longestStreak = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;
                if (currentStreak > longestStreak) longestStreak = currentStreak;
            } else {
                currentStreak = 0;
            }
        }
        return new int[]{present, longestStreak};
    }

    public static void main(String[] args) {
        int[][] samples = {{1, 1, 0, 1, 1, 1, 0, 1}, {0, 0, 0}};
        for (int[] days : samples) {
            int[] result = attendanceSummary(days);
            System.out.println("days = " + Arrays.toString(days) + " -> Present: " + result[0] + ", Longest streak: " + result[1]);
        }
    }
}
