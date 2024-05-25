import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.*;

public class AccountTest {
    private Customer customer;
    private Account account;

    @Before
    public void setUp() {
        // Create a customer for testing
        LocalDate dob = LocalDate.of(1990, 1, 1);
        customer = new Customer("John Doe", "123 Main St", "ABC123", 123456789, dob);

        // Create a current account for testing
       // account = new CurrentAccount(customer);
       // account.activate(); // Activate the account

        // Create a savings account for testing
        //account = new SavingsAccount(customer);
        //account.activate(); // Activate the account

        // Create a high interest savings account for testing
        account = new HighInterestSavingsAccount(customer);
        account.activate(); // Activate the account


    }


    @Test
    public void testDeposit() {
        // Perform a deposit
        int initialBalance = account.getBalance();
        int depositAmount = 100; //Interest to be applied for saving and high interest accounts(110&120)
        account.deposit(depositAmount);

        // Check if the balance is updated correctly
        assertEquals(initialBalance + depositAmount, account.getBalance());
    }

    @Test
    public void testWithdrawSufficientFunds() {
        // Deposit some money into the account
        account.deposit(500);

        // Perform a withdrawal
        int initialBalance = account.getBalance();
        int withdrawalAmount = 200;
        account.withdraw(withdrawalAmount);

        // Check if the balance is updated correctly
        assertEquals(initialBalance - withdrawalAmount, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        // Perform a withdrawal with insufficient funds
        int withdrawalAmount = 200;
        account.withdraw(withdrawalAmount);

        // Check if the balance remains unchanged
        assertEquals(0, account.getBalance());
    }

    @Test
    public void testNumberOfTransactions() {
        // Perform some transactions
        account.deposit(100);
        account.withdraw(50);
        account.deposit(200);

        // Check if the number of transactions is correct
        assertEquals(3, account.numberOfTransactions());
    }

    @Test
    public void testActivate() {
        // Deactivate the account
        account.deactivate();

        // Activate the account
        account.activate();

        // Check if the account is active
        assertTrue(account.isActive());
    }

    @Test
    public void testDeactivate() {
        // Deactivate the account
        account.deactivate();

        // Check if the account is inactive
        assertFalse(account.isActive());
    }

    @Test
    public void testGetAccountType() {
        // Check if the account type is correct
        assertEquals("Current Account", account.getAccountType());
    }
}
