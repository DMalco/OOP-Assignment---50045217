import java.time.LocalDate;
import java.util.Scanner;

/**
 * Class for Input Reader via Scanner
 * @author davem
 * @version 17/04/24
 */

public class InputReader
{
    private Scanner scanner;

    public InputReader()
    {
        scanner = new Scanner(System.in);
    }

    public String getStringInput()
    {
        return scanner.nextLine();
    }

    public int getIntInput() {
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }


}


