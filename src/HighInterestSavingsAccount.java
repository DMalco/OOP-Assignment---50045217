import com.sun.org.apache.xpath.internal.objects.XString;

import java.time.LocalDate;

/**
 * Class representing High Interest Savings Accounts, with a 20% interest rate.
 */
public class HighInterestSavingsAccount extends Account {

    private final int transactionLimit = 3;
    private int transactionsThisYear = 0;
    private int currentYear = LocalDate.now().getYear();

    /**
     * Constructor to create a High Interest Savings Account.
     *
     * @param anAccountOwner The owner of the account
     */
    public HighInterestSavingsAccount(Customer anAccountOwner) {
        super(anAccountOwner);

    }

    /**
     * Overrides the deposit method to include a 20% interest.
     *
     * @param numCredit The amount to be deposited
     */
    @Override
    public void deposit(int numCredit) {
        if (transactionsThisYear >= transactionLimit) {
            System.out.println("Transaction limit for the year reached.");
            return;
        }

        int interestValue = numCredit / 100 * 20; // Calculate 20% interest
        super.deposit(numCredit + interestValue); // Add interest to the deposit
        addTransaction(new Transaction(TransactionType.DEPOSIT, numCredit)); // Record the transaction
        transactionsThisYear++; // Increment transaction count for the year
    }

    /**
     * overrides the withdrawal method to count towards transaction limit
     * @param amount The amount to be withdrawn from the account.
     */
    @Override
    public void withdraw(int amount) {
        if (transactionsThisYear < transactionLimit) {
            super.withdraw(amount);
            transactionsThisYear++;
        } else {
            System.out.println("Transaction limit for the year reached.");
        }
    }


    /**
     * Returns the account type as "High Interest Savings Account".
     *
     * @return the account type.
     */
    @Override
    public String getAccountType() {
        return "High Interest Savings Account";
    }
    /**
     * Returns the transaction limit for this account.
     * @return The transaction limit.
     */
    public int getTransactionLimit() {
        return transactionLimit;
    }

    /**
     * Returns the number of transactions made so far in the current year.
     *
     * @return Number of transactions made in the current year
     */
    public int getTransactionsThisYear() {
        if (LocalDate.now().getYear() != currentYear) {
            // Reset transaction count if a new year has started
            resetTransactionCount();
        }
        return transactionsThisYear;
    }
    /**
     * Resets the transaction count for the current year.
     * This method should be called at the beginning of each new year.
     */
    private void resetTransactionCount() {
        currentYear = LocalDate.now().getYear();
        transactionsThisYear = 0;
    }
}

    //TRANSACTION LIMIT AND TRANSACTIONS PER YEAR

