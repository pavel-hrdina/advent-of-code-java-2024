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
     * Test the measureNumberDistance method.
     * Takes two lists of integers and returns the distance between them.
     * The lists are sorted, and the method calculates the absolute difference
     * between corresponding elements from both lists.
     */
    @Test
    void testMeasureNumberDistance() {
        // Use ArrayList for mutable lists
        List<Integer> leftList = new ArrayList<>(List.of(3, 4, 2, 1, 3, 3));
        List<Integer> rightList = new ArrayList<>(List.of(4, 3, 5, 3, 9, 3));

        // Call the method that calculates the pairwise distances
        List<Integer> result = DayOne.measureNumberDistance(leftList, rightList);

        // The lists are sorted:
        // leftList -> [1, 2, 3, 3, 3, 4]
        // rightList -> [3, 3, 3, 4, 5, 9]
        // The pairwise distances will be: [2, 1, 0, 1, 2, 5]
        assertEquals(List.of(2, 1, 0, 1, 2, 5), result);
    }

    /**
     * Test the calculateTotalDistanceBetweenLists method.
     * This method uses measureNumberDistance and calculates the sum of the pairwise distances.
     */
    @Test
    void testCalculateTotalDistance() {
        // Sample input lists
        List<Integer> leftList = new ArrayList<>(List.of(3, 4, 2, 1, 3, 3));
        List<Integer> rightList = new ArrayList<>(List.of(4, 3, 5, 3, 9, 3));

        // Calculate the total distance using the method that sums the distances
        int totalDistance = DayOne.calculateTotalDistanceBetweenLists(leftList, rightList);

        // The total distance should be the sum of the pairwise distances: 2 + 1 + 0 + 1 + 2 + 5 = 11
        assertEquals(11, totalDistance);
    }
}
