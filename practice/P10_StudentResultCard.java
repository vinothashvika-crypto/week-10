import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 10 Practice 10 - Student Result Card Generator
 * Grades (as specified + my own for the gaps): B = average 75 or more, C = 60-74, D = 40-59, F = below 40.
 * Input lines look like: Asha [80, 90, 70]
 */
public class P10_StudentResultCard {

    static final String SAMPLE = "Asha [80, 90, 70]\nRavi [60, 55, 50]";

    static class Student {
        private final String name;
        private final int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks.clone();
        }

        double average() {
            int sum = 0;
            for (int m : marks) sum += m;
            return (double) sum / marks.length;
        }

        char grade() {
            double avg = average();
            if (avg >= 75) return 'B';
            else if (avg >= 60) return 'C';
            else if (avg >= 40) return 'D';
            else return 'F';
        }

        String resultLine() {
            return String.format("%s: Average %.1f, Grade %c", name.toUpperCase(), average(), grade());
        }
    }

    static Student parse(String line) {
        int bracket = line.indexOf('[');
        String name = line.substring(0, bracket).trim();
        String[] parts = line.substring(bracket + 1, line.indexOf(']')).split(",");
        int[] marks = new int[parts.length];
        for (int i = 0; i < parts.length; i++) marks[i] = Integer.parseInt(parts[i].trim());
        return new Student(name, marks);
    }

    public static void main(String[] args) throws Exception {
        for (String line : readInput()) {
            System.out.println(parse(line).resultLine());
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
