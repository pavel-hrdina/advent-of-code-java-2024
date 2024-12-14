import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test class for the third day of the advent of code 2024.
 * This class is designed to test the functionality of the DayThree class and
 * ensure that its methods operate correctly under various conditions.
 * Utilizes JUnit for unit testing.
 */
public class TestDayThree {
    private static final String testInput = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";

    private TestDayThree() {
    }

    @Test
    void testParseInput() {
        assertEquals(48, DayThree.parseInput(testInput));
    }
}