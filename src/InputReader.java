import java.util.Scanner;

public class InputReader
{
    private Scanner scanner;

    public InputReader()
    {
        scanner = new Scanner(System.in);
    }

    public String getInput()
    {
        return scanner.nextLine();
    }
}
