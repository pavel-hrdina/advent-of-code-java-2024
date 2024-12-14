/**
 * The DayThree class provides the solution for the third day's challenge
 * in the Advent of Code 2024. It contains utility methods to process
 * and parse input data for this challenge.
 */

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * The DayThree class provides utility methods for solving challenges related to day three
 * of the Advent of Code 2024.
 */
public class DayThree {
    /**
     * Private constructor to prevent instantiation of the DayThree class.
     * This class is designed as a utility class containing only static
     * methods and should not be instantiated.
     */
    private DayThree() {

    }

    /**
     * Parses the input string and converts it into a specific integer value based on
     * the challenge requirements.
     *
     * @param input input string that needs to be parsed and processed
     * @return an integer value resulting from the parsing of the input string
     */
    public static int parseInput(String input) {
        Pattern pattern = Pattern.compile("(mul\\(([0-9]+),([0-9]+)\\)|do\\(\\)|don't\\(\\))");
        Matcher matcher = pattern.matcher(input);

        final boolean[] enabled = {true}; // Use an array to work around lambda restrictions

        return Stream.generate(() -> matcher.find() ? matcher : null)
                .takeWhile(Objects::nonNull) // check if each stream element is not null
                .filter(m -> {
                    String match = m.group(0);
                    if (match.equals("do()")) {
                        enabled[0] = true;
                        return false;
                    } else if (match.equals("don't()")) {
                        enabled[0] = false;
                    }
                    return enabled[0];
                })
                .mapToInt(m -> {
                    int value1 = Integer.parseInt(m.group(2));
                    int value2 = Integer.parseInt(m.group(3));
                    return value1 * value2;
                })
                .sum();
    }
}
