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

    /**
     * Determines whether a given report is "safe" based on specific conditions.
     * A report is safe if the differences between consecutive integers in the array:
     * - Are within the range of 1 to 3 (inclusive)
     * - Maintain a valid sequence (either strictly increasing or strictly decreasing) without invalid flips
     * <p>
     * A report with a single element or no elements is considered safe by definition.
     *
     * @param report an array of integers representing the report to be evaluated
     * @return true if the report is safe according to the defined conditions; false otherwise
     */
    public static boolean isSafeReport(int[] report) {
        int len = report.length;
        if (len < 2) return true;  // Single-element or empty reports are considered safe
        int sequenceKind = (report[0] < report[1]) ? 1 : -1;

        for (int i = 0; i < len - 1; ++i) {
            int diff = report[i + 1] - report[i];
            if (Math.abs(diff) < 1 || Math.abs(diff) > 3 || sequenceKind * diff < 0) {
                return false;
            }
            if (diff < 0 && sequenceKind > 0 || diff > 0 && sequenceKind < 0) {
                sequenceKind *= -1;
            }
        }
        return true;
    }

    /**
     * tolerate a single bad level in what would otherwise be a safe report. It's like the bad level never happened!
     * <p>
     * Now, the same rules apply as before, except if removing a single level from an unsafe report would make it safe, the report instead counts as safe.
     *
     * @param report a two-dimensional integer array where each row represents a report
     * @return the number of "safe" reports in the given two-dimensional array
     */
    public static int getSafeReportsCount(int[][] report) {
        int safeReports = 0;
        for (int[] reportRow : report) {
            if (isSafeReport(reportRow)) {
                safeReports++;
            } else {
                for (int i = 0; i < reportRow.length; i++) {
                    int[] newReportRow = new int[reportRow.length - 1];
                    System.arraycopy(reportRow, 0, newReportRow, 0, i);
                    System.arraycopy(reportRow, i + 1, newReportRow, i, reportRow.length - i - 1);
                    if (isSafeReport(newReportRow)) {
                        safeReports++;
                        break;
                    }
                }
            }
        }
        return safeReports;
    }

    /**
     * Sets the value of the two-dimensional integer array `report` for the `DayTwo` class.
     *
     * @param report a two-dimensional integer array representing the report data to be set
     */
    public static void setReport(int[][] report) {
        DayTwo.report = report;
    }
}
