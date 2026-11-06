import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 10 Practice 1 - Vowel and Consonant Counter
 * Reads one word per line/token (alphabetic, case-insensitive). With no input, uses the sample "Programming".
 */
public class P01_VowelConsonantCounter {

    static final String SAMPLE = "Programming";

    static int[] countVowelsAndConsonants(String word) {
        int vowels = 0, consonants = 0;
        for (char ch : word.toLowerCase().toCharArray()) {
            if (!Character.isLetter(ch)) continue;
            if ("aeiou".indexOf(ch) >= 0) vowels++;
            else consonants++;
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) throws Exception {
        for (String line : readInput()) {
            for (String word : line.trim().split("\\s+")) {
                int[] counts = countVowelsAndConsonants(word);
                System.out.println("Vowels: " + counts[0]);
                System.out.println("Consonants: " + counts[1]);
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
