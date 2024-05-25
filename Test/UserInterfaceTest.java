import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class UserInterfaceTest {
    private Bank bank;
    private Customer c;

    @Before
    public void setUp() {
        // Initialize the Bank instance before each test
        bank = new Bank();

        // Create a sample customer
        LocalDate ld = LocalDate.parse("1999-01-23");
        c = new Customer("John", "123 Main Street", "bt123ab", 1234567, ld);
    }

    // Method to simulate user input
    private void provideInput(String data) {
        InputStream testInput = new ByteArrayInputStream(data.getBytes());
        System.setIn(testInput);
    }

    // Method to capture console output
    private ByteArrayOutputStream captureOutput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }

    @Test
    public void deposit() {
        // Create an instance of UserInterface
        UserInterface ui = new UserInterface();

        // Mock some customer data
        String customerData = c.toString();
        provideInput(customerData);

        // Add a customer to the bank
        ui.addCustomer();

        // Deposit some money into the account
        provideInput("5\n"); // Choose option 5 (Open Account)
        provideInput("3\n"); // Choose option 3 (High Interest Savings Account)
        provideInput("123456\n"); // Enter customer ID
        provideInput("500\n"); // Deposit $500
        ui.deposit();

        // Validate the balance in the account
        Account account = bank.getAccount(1); // Assuming account number 1
        assertEquals(500, account.getBalance());
    }


}
