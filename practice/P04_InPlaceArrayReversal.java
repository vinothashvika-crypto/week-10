import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Week 10 Practice 4 - In-Place Array Reversal (two pointers, no second array). O(n) time, O(1) space.
 */
public class P04_InPlaceArrayReversal {

    static final String SAMPLE = "[11, 22, 33, 44]";

    static void reverseInPlace(int[] tokens) {
        int left = 0, right = tokens.length - 1;
        while (left < right) {
            int temp = tokens[left];
            tokens[left] = tokens[right];
            tokens[right] = temp;
            left++;
            right--;
        }
    }

    static int[] parseNumbers(String text) {
        String[] parts = text.replace("[", " ").replace("]", " ").replace(",", " ").trim().split("\\s+");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) numbers[i] = Integer.parseInt(parts[i]);
        return numbers;
    }

    public static void main(String[] args) throws Exception {
        for (String line : readInput()) {
            int[] tokens = parseNumbers(line);
            reverseInPlace(tokens);
            System.out.println(Arrays.toString(tokens));
        }
    }

    // Reads piped/redirected input; falls back to the sample when nothing is provided
    static List<String> readInput() throws Exception {
        for (int i = 0; i < 10 && System.in.available() == 0; i++) Thread.sleep(20);
        List<String> lines = new ArrayList<String>();
        if (System.in.available() > 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = reader.readLine()) != null) if (!line.trim().isEmpty()) lines.add(line);
        }
        if (lines.isEmpty()) {
            System.err.println("(no input given - using the sample input)");
            for (String line : SAMPLE.split("\n")) lines.add(line);
        }
        return lines;
    }
}
