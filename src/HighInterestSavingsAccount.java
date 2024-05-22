import com.sun.org.apache.xpath.internal.objects.XString;

import java.time.LocalDate;

/**
 * Class representing High Interest Savings Accounts, with a 20% interest rate.
 */
public class HighInterestSavingsAccount extends Account {

    private int transactionLimit = 10;
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
        int interestValue = numCredit / 100 * 20; // Calculate 20% interest
        super.deposit(numCredit + interestValue); // Add interest to the deposit
    }

    //TRANSACTION LIMIT AND TRANSACTIONS PER YEAR
}
