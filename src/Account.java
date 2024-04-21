import java.time.LocalDate;

/**
 * Class for Account admin
 * @author davem
 * @version 18/04/24
 */
public class Account {
    private int accountNum;
    private int sortCode;
    private String accountOwner;
    private int accountBalance;
    private LocalDate openDate;
    private boolean isClosed;//Open/Closed MAYBE BOOLEAN?
    private LocalDate closureDate;//(If Closed)
    private int closingBalance;//(If Closed)

    /**
     * Constructor to create an object of the Account Class
     * @param aAccountNum
     * @param aSortCode
     * @param anAccountOwner
     * @param aAccountBalance
     * @param aOpenDate
     * @param theCloseDate
     * @param theClosingBalance
     */
    public Account(int aAccountNum, int aSortCode, String anAccountOwner, int aAccountBalance, LocalDate aOpenDate, LocalDate theCloseDate, int theClosingBalance)
    {
        this.accountNum = aAccountNum;
        this.sortCode = aSortCode;
        this.accountOwner = anAccountOwner;
        this.accountBalance = aAccountBalance;
        this.openDate = aOpenDate;
        this.isClosed = false;
        this.closureDate = theCloseDate;
        this.closingBalance = theClosingBalance;
    }

    /**
     * Getter for Account Number
     * @return Account Number
     */
    public int getAccountNum() {
        return accountNum;
    }

    /**
     * Getter for account Sort Code
     * @return Sort Code
     */
    public int getSortCode() {
        return sortCode;
    }

    /**
     * Getter for Account Owner name
     * @return Account Owner
     */
    public String getAccountOwner() {
        return accountOwner;
    }

    /**
     * Getter for Account Balance
     * @return Account Balance
     */
    public int getAccountBalance() {
        return accountBalance;
    }

    /**
     * Getter for Account Opening Date
     * @return Account Open Date
     */
    public LocalDate getOpenDate() {
        return openDate;
    }

    /**
     * Getter for Account Status (Open/Closed)
     * @return Account Status (Open/Closed)
     */
    public String getIsClosed() {
        String status;
        if(this.isClosed)
        {
            status = "Closed";
        }
        else
        {
            status = "Open";
        }
        return status;
    }

    /**
     * Getter for Account Closure Date (if closed)
     * @return Account Closure Date (if closed)
     */
    public LocalDate getClosureDate() {
        return closureDate;
    }

    /**
     * Getter for Account Closure Balance (if closed)
     * @return Closing Account Balance (if closed)
     */
    public int getClosingBalance() {
        return closingBalance;
    }

    /**
     *Setter for Account Status (Open/Closed)
     * @param closed to set Account Status to closed
     */
    public void setClosed(boolean closed) {
        isClosed = closed;
    }

}