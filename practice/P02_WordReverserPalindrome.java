import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 10 Practice 2 - Word Reverser and Palindrome Checker (StringBuilder, case-sensitive)
 */
public class P02_WordReverserPalindrome {

    static final String SAMPLE = "level\njava";

    static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        for (String line : readInput()) {
            for (String word : line.trim().split("\\s+")) {
                String reversed = reverse(word);
                boolean palindrome = reversed.equals(word);
                System.out.println(reversed + " - " + (palindrome ? "palindrome" : "not a palindrome"));
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
