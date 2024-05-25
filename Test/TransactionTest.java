import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import static org.junit.Assert.*;

public class TransactionTest {
    private Transaction transaction;

    @Before
    public void setUp() {
        // Initialize a transaction before each test
        transaction = new Transaction(TransactionType.DEPOSIT, 500);
    }

    @Test
    public void testGetTransactionID() {
        // Check if the transaction ID is initialized correctly
        assertEquals(1, transaction.getTransactionID());
    }

    @Test
    public void testGetValue() {
        // Check if the transaction value is initialized correctly
        assertEquals(500, transaction.getValue());
    }

    @Test
    public void testGetTransactionDateTime() {
        // Check if the transaction date and time is initialized correctly
        assertNotNull(transaction.getTransactionDateTime());
    }

    @Test
    public void testGetType() {
        // Check if the transaction type is initialized correctly
        assertEquals(TransactionType.DEPOSIT, transaction.getType());
    }

    @Test
    public void testShowDetails() {
        // Capture console output
        ByteArrayOutputStream output = captureOutput();

        // Display transaction details
        transaction.showDetails();

        // Validate the output
        String expectedOutput = "Transaction ID: 1, Type: DEPOSIT, Value: 500, Date + Time: " + transaction.getTransactionDateTime().toString() + "\n";
        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testEquals() {
        // Create a new transaction with the same ID as the first transaction
        Transaction sameTransaction = new Transaction(TransactionType.DEPOSIT, 500) {
            @Override
            public int getTransactionID() {
                return transaction.getTransactionID();
            }
        };

        // Check if the two transactions are equal
        assertTrue(transaction.equals(sameTransaction));
    }

    // Method to capture console output
    private ByteArrayOutputStream captureOutput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }
}
