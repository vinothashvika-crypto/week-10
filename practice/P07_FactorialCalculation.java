import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

/**
 * Week 10 Practice 7 - Factorial Calculation (0! = 1). BigInteger so large n doesn't overflow.
 */
public class P07_FactorialCalculation {

    static final String SAMPLE = "5\n0";

    static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        for (String line : readInput()) {
            for (String token : line.trim().split("\\s+")) {
                int n = Integer.parseInt(token);
                if (n < 0) {
                    System.out.println("Factorial is not defined for negative numbers");
                } else {
                    System.out.println(factorial(n));
                }
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
