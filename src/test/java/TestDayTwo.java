/**
 * A class to test the DayTwo class
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the first day of the advent of code 2024
 */
public class TestDayTwo {
    /**
     * Private constructor for the TestDayTwo class.
     * Prevents the instantiation of the class, as it is designed for testing purposes
     * and contains static methods for validation.
     */
    private TestDayTwo() {
    }

    /**
     * Private constructor for the TestDayTwo class.
     * Initializes the static two-dimensional array `report` from the `DayTwo` class.
     * This array serves as test data to validate the behavior of methods in the `DayTwo` class.
     */
    @BeforeEach
    public void setup() {
        DayTwo.setReport(new int[][]{
                {7, 6, 4, 2, 1},
                {1, 2, 7, 8, 9},
                {9, 7, 6, 2, 1},
                {1, 3, 2, 4, 5},
                {8, 6, 4, 4, 1},
                {1, 3, 6, 7, 9},
        });
    }

    /**
     * Tests the findSafeReports method in the DayTwo class.
     * Validates that the method correctly identifies and counts the "safe" reports
     */
    @Test
    void testFindSafeReports() {
        assertEquals(2, DayTwo.findSafeReports(DayTwo.report));
    }

    /**
     * Tests the getSafeReports method.
     */
    @Test
    void testGetSafeReports() {
        assertEquals(4, DayTwo.getSafeReportsCount(DayTwo.report));
    }

}
