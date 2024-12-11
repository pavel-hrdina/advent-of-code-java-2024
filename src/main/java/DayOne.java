/**
 * DayOne challenge
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The solution for the first day of the advent of code 2024
 */
public class DayOne {
    /**
     * A static list of integers representing the "left" side in operations involving two lists.
     * This list is used as an input parameter for various calculations.
     */
    static List<Integer> leftList;

    /**
     * Represents a list of integers on the right side that is used in computations
     * such as measuring distances or similarities between two lists of integers.
     * This list is paired with the left list to calculate various properties.
     */
    static List<Integer> rightList;

    /**
     * Private constructor to prevent instantiation of the DayOne class.
     * This class is designed to serve as a utility class with static methods.
     */
    private DayOne() {
        leftList = new ArrayList<>();
        rightList = new ArrayList<>();
    }

    /**
     * <p>Calculate the total distance between two lists of integers by adding up
     * the distances between all the pairs of numbers in the two lists.</p>
     *
     * @param leftList  the first list of integers
     * @param rightList the second list of integers
     * @return the total distance between the two lists
     */
    public static int calculateTotalDistanceBetweenLists(List<Integer> leftList, List<Integer> rightList) {
        List<Integer> totalDistance = measureNumberDistance(leftList, rightList);
        return totalDistance.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * <p>Measure the distance between two lists of integers by pairing up the
     * smallest numbers in each list and subtracting the bigger number from the
     * smaller number. Add the result to the total distance list that is returned
     * by the method.</p>
     *
     * @param leftList  the first list of integers
     * @param rightList the second list of integers
     * @return the list of distances between the numbers in the two lists
     */
    public static List<Integer> measureNumberDistance(List<Integer> leftList, List<Integer> rightList) {
        if (leftList.size() != rightList.size()) {
            throw new IllegalArgumentException("The lists must be of the same size");
        }
        if (leftList.isEmpty()) {
            throw new IllegalArgumentException("The lists must not be empty");
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        List<Integer> totalDistance = new ArrayList<>();
        for (int i = 0; i < leftList.size(); i++) {
            totalDistance.add(Math.abs(leftList.get(i) - rightList.get(i)));
        }
        return totalDistance;
    }

    /**
     * This method calculates the number of times a number can be found in the
     * opposing list and vise versa, then it adds those 'scores together' resulting in one number
     *
     * @param leftList  The input list on the left
     * @param rightList The input list on the right
     * @return the total score as list.
     */
    public static int mesureSimularityScore(List<Integer> leftList, List<Integer> rightList) {
        int score = 0;
        for (int i : leftList) {
            int occurrences = Collections.frequency(rightList, i);
            score += i * occurrences;
        }

        return score;
    }

}
