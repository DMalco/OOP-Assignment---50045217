import java.time.LocalDate;
import java.util.HashSet;

/**
 * Abstract Account Class
 * Represents a bank account.
 * Contains methods to manage account operations such as deposit, withdrawal, and transaction history.
 * @author davem
 * @version 18/04/24
 */
public abstract class Account {
    private static int NEXT_ACCOUNT_NUMBER = 1;
    private int accountNum;
    private int sortCode;
    private int accountBalance;
    private LocalDate openDate;
    private boolean active; // Indicates whether the account is open or closed
    private LocalDate closureDate; // Date when the account was closed
    private int closingBalance; // Balance when the account was closed

    private Customer accountOwner;
    private HashSet<Transaction> transactions;


    /**
     * Constructor to create an object of the Account Class.
     * Initializes account details and assigns an account number.
     *
     * @param anAccountOwner The customer who owns the account.
     */
    public Account(Customer anAccountOwner) {
        this.accountNum = Account.NEXT_ACCOUNT_NUMBER;
        NEXT_ACCOUNT_NUMBER++;
        this.sortCode = 938363;
        this.accountOwner = anAccountOwner;
        this.accountBalance = 0;
        this.openDate = null;
        this.active = false;
        this.closureDate = null;
        this.closingBalance = 0;
        this.transactions = new HashSet<>();

    }

    /**
     * Getter for Account Number
     *
     * @return Account Number
     */
    public int getAccountNum() {
        return accountNum;
    }

    /**
     * Getter for Account Sort Code
     *
     * @return Sort Code
     */
    public int getSortCode() {
        return sortCode;
    }


    /**
     * Getter for Account Owner name
     *
     * @return Account Owner
     */
    public Customer getAccountOwner() {
        return this.accountOwner;
    }

    /**
     * Getter for Account open/closed status
     *
     * @return Account open/close status
     */
    public boolean isActive() {
        return this.active;
    }


    /**
     * Sets account status to open and records open date
     */
    public void activate() {
        this.active = true;
        this.openDate = LocalDate.now();
    }

    /**
     * Sets account status to closed and records closure date. Sets current balance as closing balance
     */
    public void deactivate() {
        this.active = false;
        this.closureDate = LocalDate.now();
        this.closingBalance = accountBalance;
    }

    /**
     * returns the date on which the Account was opened as a String
     *
     * @return the date on which the Account was opened as a String
     */
    public String getDateActivated() {
        String date;
        if (this.openDate != null) {
            date = this.openDate.toString();
        } else {
            date = "The Account has not been opened";
        }
        return date;
    }

    /**
     * Returns the date on which the pass was deactivated as a String
     *
     * @return the date on which the pass was deactivated as a String
     */
    public String getDateDeactivated() {
        String date;
        if (this.openDate == null) {
            date = "The Pass has not been activated";
        } else if (this.openDate != null && this.closureDate == null) {
            date = "the Pass is still active";
        } else {
            date = this.closureDate.toString();
        }
        return date;
    }

    /**
     * Get current balance of account
     *
     * @return account balance
     */
    public int getBalance() {
        return this.accountBalance;
    }

    /**
     * Deposits money into the account.
     *
     * @param numValue The amount to be deposited into the account.
     */
    public void deposit(int numValue) {
        this.accountBalance += numValue;
    }

    /**
     * Withdraws money from the account.
     *
     * @param numValue The amount to be withdrawn from the account.
     */
    public void withdraw(int numValue) {
        if (numValue <= this.accountBalance) {
            this.accountBalance -= numValue;
        } else {
            System.out.println("Insufficient Funds");
        }
    }

    /**
     * Displays the number of transactions on the account.
     *
     * @return The number of transactions on the account.
     */
    public int numberOfTransactions() {
        return this.transactions.size();
    }

    /**
     * Adds a transaction to the account.
     *
     * @param t The transaction to be added to the account.
     */
    public void addTransaction(Transaction t) {
        this.transactions.add(t);
    }

    /**
     * Displays all details for the account including customer ID, sort code, account number, balance, status, and activation/closure date.
     */
    public void displayDetails() {
        String status;
        String date;

        if (this.isActive()) {
            status = " Account Open ";
            date = "Date opened: " + this.getDateActivated();
        } else {
            status = "Account Closed ";
            date = "Date opened: " + this.getDateActivated() + " , Date closed: " + this.getDateDeactivated();
        }

        System.out.println("Customer ID: " + this.accountOwner.getCustomerID() + " , " + "Sort Code: " + getSortCode() + " , " +
                "Account Number: " + getAccountNum() + " , " +
                "Balance: " + this.getBalance() + " , " + status + ", " + date);
    }

    /**
     * Shows details of transactions on the account.
     */
    public void showTransactions() {
        System.out.println("Total transactions: " + numberOfTransactions());

        for (Transaction t : this.transactions) {
            t.showDetails();
        }
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
            if(obj instanceof  Account)
            {
                Account otherAccount = (Account) obj;

                if(otherAccount.getAccountNum() == this.getAccountNum())
                {
                    equal = true;
                }
            }
        }

        return equal;
    }

}