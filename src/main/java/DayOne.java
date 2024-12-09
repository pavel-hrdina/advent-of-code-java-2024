/**
 * DayOne of the Advent of Code 2024
 *
 * @author Pavel Hrdina
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * The solution for the first day of the advent of code 2024
 */
public class DayOne {
    public static void main(String[] args) {
        // Path to the input file
        String fileName = "/home/hrdina/IdeaProjects/advent-of-code-java-2024/input";  // You can modify this to point to your file

        // Lists to store the two columns
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        try {
            // Create a Scanner object to read from the file
            Scanner scanner = new Scanner(new File(fileName));

            // Read the input file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) {
                    continue; // Skip empty lines
                }

                // Split the line by spaces and parse the integers
                String[] numbers = line.split(" ");
                if (numbers.length == 2) {
                    leftList.add(Integer.parseInt(numbers[0]));   // First number
                    rightList.add(Integer.parseInt(numbers[1]));  // Second number
                }
            }

            // Now that the lists are populated, calculate the total distance
            if (leftList.isEmpty() || rightList.isEmpty()) {
                System.out.println("Error: Lists are empty. Exiting...");
                return;
            }

            // Print the lists to verify the input
            System.out.println("Left List: " + leftList);
            System.out.println("Right List: " + rightList);

            // Example usage of the methods (you can customize this part)
            int totalDistance = calculateTotalDistanceBetweenLists(leftList, rightList);
            System.out.println("Total Distance: " + totalDistance);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Exiting...");
            e.printStackTrace();
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

    // Method to convert user input string to a List of Integers
    public static List<Integer> parseInputToList(String input) {
        List<Integer> list = new ArrayList<>();
        String[] numbers = input.split(" ");  // Split the input string by spaces
        for (String num : numbers) {
            list.add(Integer.parseInt(num));  // Convert each string to an integer
        }
        return list;
    }
}
