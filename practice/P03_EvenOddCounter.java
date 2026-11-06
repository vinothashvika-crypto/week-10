import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 10 Practice 3 - Even and Odd Numbers in a List
 * Input like "[3, 8, 12, 5, 7, 10]" (brackets and commas optional).
 */
public class P03_EvenOddCounter {

    static final String SAMPLE = "[3, 8, 12, 5, 7, 10]";

    static int[] parseNumbers(String text) {
        String[] parts = text.replace("[", " ").replace("]", " ").replace(",", " ").trim().split("\\s+");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) numbers[i] = Integer.parseInt(parts[i]);
        return numbers;
    }

    public static void main(String[] args) throws Exception {
        for (String line : readInput()) {
            int even = 0, odd = 0;
            for (int n : parseNumbers(line)) {
                if (n % 2 == 0) even++;
                else odd++;
            }
            System.out.println("Even: " + even);
            System.out.println("Odd: " + odd);
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
