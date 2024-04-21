import java.time.LocalDate;

/**
 * Class for Transaction admin
 * @author davem
 * @version 18/04/24
 */
public class Transaction {
    private int transactionID;
    private int accountNum;
    private LocalDate transactionDate;
    private String type; //Deposit/withdrawal
    private int amount;


    /**
     * Constructor to create an object of the Transaction Class
     * @param aTransactionID Unique transaction ID number
     * @param aAccountNum Account number
     * @param aTransactionDate Date of transaction
     * @param aType Type of transaction (Deposit/Withdrawal)
     * @param anAmount Amount of money in transaction
     */
    public Transaction(int aTransactionID, int aAccountNum, LocalDate aTransactionDate, String aType, int anAmount)
    {
        this.transactionID = aTransactionID;
        this.accountNum = aAccountNum;
        this.transactionDate = aTransactionDate;
        this.type = aType;
        this.amount = anAmount;
    }

    /**
     * Getter for Transaction ID
     * @return Transaction ID
     */
    public int getTransactionID() {
        return transactionID;
    }

    /**
     * Getter for Customer Account number in transaction
     * @return Account Number
     */
    public int getAccountNum() {
        return accountNum;
    }

    /**
     * Getter for Date of transaction
     * @return Date of Transaction
     */
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    /**
     * Getter for Type of transaction (Deposit/Withdrawal)
     * @return Type of transaction
     */
    public String getType() {
        return type;
    }

    /**
     * Getter for amount of money in transaction
     * @return Amount in transaction
     */
    public int getAmount() {
        return amount;
    }



}
