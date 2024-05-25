import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Class for managing transactions in the banking system.
 * This class represents individual transactions made by customers, including details such as transaction ID, value, date and time, and type (deposit/withdrawal).
 * @author davem
 * @version 18/04/24
 */
public class Transaction {
    private static int NEXT_TRANSACTION_ID = 1;
    private final int transactionID;
    private final int value;
    private final LocalDateTime transactionDateTime;
    private final TransactionType type; // Deposit/withdrawal

    /**
     * Constructor to create a Transaction object.
     * @param aType The type of transaction (Deposit/Withdrawal)
     * @param numValue The value of the transaction
     */
    public Transaction(TransactionType aType, int numValue) {
        this.type = aType;
        this.value = numValue;
        this.transactionDateTime = LocalDateTime.now();
        this.transactionID = NEXT_TRANSACTION_ID;
        NEXT_TRANSACTION_ID++;
    }

    /**
     * Getter for the transaction ID.
     * @return The transaction ID
     */
    public int getTransactionID() {
        return transactionID;
    }

    /**
     * Getter for the transaction value.
     * @return The transaction value
     */
    public int getValue() {
        return value;
    }

    /**
     * Getter for the transaction date and time.
     * @return The transaction date and time
     */
    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    /**
     * Getter for the transaction type (Deposit/Withdrawal).
     * @return The transaction type
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * Display the details of the transaction.
     * Prints out the transaction type, value, date and time, and transaction ID.
     */
    public void showDetails() {
        System.out.println("Transaction ID: " + transactionID + ", " + "Type: " +this.type.toString() + ", Value: " + this.value + ", Date + Time: " + this.transactionDateTime.toString());
    }

    @Override
    public boolean equals(Object obj)
    {

        boolean equal = false;
        if (obj == this)
        {
            equal = true;
        }
        else // memory references do not match
        {
            if(obj instanceof  Transaction)
            {
                Transaction otherTransaction = (Transaction) obj;

                if(otherTransaction.getTransactionID() == this.getTransactionID())
                {
                    equal = true;
                }
            }
        }

        return equal;
    }
}
