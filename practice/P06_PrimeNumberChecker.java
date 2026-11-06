import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 10 Practice 6 - Prime Number Checker (trial division up to the square root)
 */
public class P06_PrimeNumberChecker {

    static final String SAMPLE = "29\n21";

    static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (long d = 3; d * d <= n; d += 2) {
            if (n % d == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        for (String line : readInput()) {
            for (String token : line.trim().split("\\s+")) {
                long n = Long.parseLong(token);
                System.out.println(n + (isPrime(n) ? " is prime" : " is not prime"));
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
