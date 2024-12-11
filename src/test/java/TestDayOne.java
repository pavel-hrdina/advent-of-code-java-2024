/**
 * A class to test the DayOne class
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the first day of the advent of code 2024
 */
public class TestDayOne {
    /**
     * Represents a static list of integers used in various calculations involving
     * pairwise comparisons and distance measurements.
     */
    private static List<Integer> leftList;
    /**
     * Represents a static list of integers used in various calculations involving
     * comparison or distance measurement.
     */
    private static List<Integer> rightList;

    /**
     * Constructs an instance of TestDayOne and initializes the static lists
     * used for testing.
     */
    private TestDayOne() {
        leftList = new ArrayList<>(List.of(3, 4, 2, 1, 3, 3));
        rightList = new ArrayList<>(List.of(4, 3, 5, 3, 9, 3));
    }

    /**
     * Test the measureNumberDistance method.
     * Takes two lists of integers and returns the distance between them.
     * The lists are sorted, and the method calculates the absolute difference
     * between corresponding elements from both lists.
     */
    @Test
    void testMeasureNumberDistance() {
        List<Integer> result = DayOne.measureNumberDistance(leftList, rightList);
        assertEquals(List.of(2, 1, 0, 1, 2, 5), result);
    }

    /**
     * Test the calculateTotalDistanceBetweenLists method.
     * This method uses measureNumberDistance and calculates the sum of the pairwise distances.
     */
    @Test
    void testCalculateTotalDistance() {
        int totalDistance = DayOne.calculateTotalDistanceBetweenLists(leftList, rightList);
        assertEquals(11, totalDistance);
    }

    /**
     * Test that the method calculates a similarity score between two lists of
     * integers based on the frequency of common elements between the lists.
     */
    @Test
    void testMesureSimularityScore() {
        int score = DayOne.mesureSimularityScore(leftList, rightList);
        // for these example lists, the similarity score at the end of this process is 31 (9 + 4 + 9 + 9).
        assertEquals(31, score);
    }
}
