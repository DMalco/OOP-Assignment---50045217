import java.util.Scanner;

/**
 * Class for reading user input via Scanner.
 */
public class InputReader {

    private Scanner scanner;

    /**
     * Constructor to initialize the InputReader with a Scanner object.
     */
    public InputReader() {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads a string input from the user.
     *
     * @return The string input from the user
     */
    public String getStringInput() {
        return scanner.nextLine();
    }

    /**
     * Reads an integer input from the user.
     *
     * @return The integer input from the user
     */
    public int getIntInput() {
        int input = scanner.nextInt(); // Read integer input
        scanner.nextLine(); // Consume the newline character
        return input;
    }
}
