import java.time.LocalDate;

/**
 * Class for Savings Accounts (10%)
 * This class represents a savings account, which extends the Account class.
 * It applies a 10% interest on deposits.
 * @author davem
 * @version 20/05/24
 */
public class SavingsAccount extends Account {

    /**
     * Constructs a SavingsAccount object with the specified account owner.
     * @param anAccountOwner the owner of the account
     */
    public SavingsAccount(Customer anAccountOwner) {
        super(anAccountOwner);
    }

    /**
     * Deposits money into the savings account, applying a 10% interest.
     * @param numCredit the amount of money to deposit
     */
    @Override
    public void deposit(int numCredit) {
        int interestValue = numCredit / 100 * 10; // Calculate interest value (10%)
        super.deposit(numCredit + interestValue); // Add interest to the deposit amount
    }
}

