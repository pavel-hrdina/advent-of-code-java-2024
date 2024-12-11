/**
 * DayOne of the Advent of Code 2024
 *
 * @author Pavel Hrdina
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * The solution for the first day of the advent of code 2024
 */
public class DayOne {
    /**
     * The default constructor
     */
    public DayOne() {
    }

    /**
     * The main method to read the input file and calculate the total distance between two lists of integers
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws IOException {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(args[0]));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] numbers = line.split("\\s+");
                if (numbers.length == 2) {
                    leftList.add(Integer.parseInt(numbers[0]));   // First number
                    rightList.add(Integer.parseInt(numbers[1]));  // Second number
                }
            }

            if (leftList.isEmpty() || rightList.isEmpty()) {
                throw new IOException("The files must not be empty.");
            }
            System.out.println("Total Distance: " + calculateTotalDistanceBetweenLists(leftList, rightList));

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Exiting...");
        }
    }

    /**
     * <p>Calculate the total distance between two lists of integers by adding up
     * the distances between all of the pairs of numbers in the two lists.</p>
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

}
