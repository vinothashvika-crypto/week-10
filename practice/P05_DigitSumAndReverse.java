import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 10 Practice 5 - Digit Sum and Number Reversal (using % 10 and / 10)
 */
public class P05_DigitSumAndReverse {

    static final String SAMPLE = "4721";

    public static void main(String[] args) throws Exception {
        for (String line : readInput()) {
            for (String token : line.trim().split("\\s+")) {
                long number = Long.parseLong(token);
                long sum = 0, reversed = 0;
                while (number > 0) {
                    long digit = number % 10;
                    sum += digit;
                    reversed = reversed * 10 + digit;
                    number /= 10;
                }
                System.out.println("Sum of digits: " + sum);
                System.out.println("Reverse: " + reversed);
            }
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
