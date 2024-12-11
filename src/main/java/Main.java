/**
 * DayOne of the Advent of Code 2024
 *
 * @author Pavel Hrdina
 * @date December 9, 2024
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Main class serves as the entry point for the application.
 */
public class Main {
    /**
     * Private constructor to prevent instantiation of the Main class.
     * The Main class is designed to serve as an entry point for the program
     * and should not be instantiated.
     */
    private Main() {
    }

    /**
     * The main method to read the input file and calculate the total distance between two lists of integers
     *
     * @param args the command-line arguments
     * @throws IOException if the file cant be read, throw an exception.
     */
    public static void main(String[] args) throws IOException {
        DayOne.leftList = new ArrayList<>();
        DayOne.rightList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(args[0]));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] numbers = line.split("\\s+");
                if (numbers.length == 2) {
                    DayOne.leftList.add(Integer.parseInt(numbers[0]));   // First number
                    DayOne.rightList.add(Integer.parseInt(numbers[1]));  // Second number
                }
            }

            if (DayOne.leftList.isEmpty() || DayOne.rightList.isEmpty()) {
                throw new IOException("The files must not be empty.");
            }
            System.out.println("Total Distance: " + DayOne.calculateTotalDistanceBetweenLists(DayOne.leftList, DayOne.rightList));
            System.out.println("Similarity Score: " + DayOne.mesureSimularityScore(DayOne.leftList, DayOne.rightList));

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Exiting...");
        }
    }
}
