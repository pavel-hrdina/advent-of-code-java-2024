/**
 * Days of the Advent of Code 2024
 *
 * @author Pavel Hrdina
 * @date December 9, 2024
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        String input = Files.readString(Paths.get(args[0]));
        System.out.println(DayThree.parseInput(input));
    }

}
