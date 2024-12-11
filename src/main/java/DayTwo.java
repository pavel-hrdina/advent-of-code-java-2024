/**
 * The DayTwo class serves as a solution for the second day of the Advent of Code 2024.
 */

/**
 * The DayTwo class for the second day of the Advent of Code 2024.
 */
public class DayTwo {
    /**
     * A two-dimensional integer array used to store and represent data in a tabular format.
     */
    static int[][] report;

    /**
     * Private constructor to prevent instantiation of the DayTwo class.
     * This class is designed to serve as a utility class with static methods.
     */
    private DayTwo() {
    }

    /**
     * Counts the number of "safe" reports in a two-dimensional array.
     * A report (row in the array) is considered "safe" if all numbers
     * in the row are in non-decreasing order.
     *
     * @param reports a two-dimensional array of integers representing multiple reports
     * @return the count of "safe" reports where all numbers are in non-decreasing order
     */
    public static int findSafeReports(int[][] reports) {
        int safeReports = 0;
        for (int[] report : reports) {
            if (isSafeReport(report)) {
                safeReports++;
            }
        }
        return safeReports;
    }

    public static boolean isSafeReport(int[] report) {
        int len = report.length;
        if (len < 2) return true;  // Single-element or empty reports are considered safe

        // Define the kind of sequence that report starts with:
        // 1 for increasing (report[1] > report[0]), -1 for decreasing (report[1] < report[0])
        int sequenceKind = (report[0] < report[1]) ? 1 : -1;

        for (int i = 0; i < len - 1; ++i) {
            int diff = report[i + 1] - report[i];

            // If difference is not in range 1 to 3 or the sequence of the numbers has wrongly flipped
            if (Math.abs(diff) < 1 || Math.abs(diff) > 3 || sequenceKind * diff < 0) {
                return false;
            }

            // If the sequence has flipped, flip our sequence indicator
            if (diff < 0 && sequenceKind > 0 || diff > 0 && sequenceKind < 0) {
                sequenceKind *= -1;
            }
        }
        return true;
    }


    public static void setReport(int[][] report) {
        DayTwo.report = report;
    }
}
