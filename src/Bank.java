import java.util.HashSet;
import java.util.Set;

/**
 * Bank Class
 */
public class Bank {
    private HashSet<Customer> customers;
    private HashSet<Account> accounts;

    /**
     * Constructor to create a Bank object.
     */
    public Bank() {
        this.customers = new HashSet<>();
        this.accounts = new HashSet<>();
    }

    /**
     * Adds a customer to the bank.
     * @param customer The customer to add.
     */
    public void addCustomer(Customer customer) {
        if (customer == null) {
            System.out.println("Cannot add null customer.");
            return;
        }
        if (customers.contains(customer)) {
            System.out.println("Customer already exists.");
        } else {
            customers.add(customer);
            System.out.println("Customer added successfully.");
        }
    }

    /**
     * Removes a customer from the bank by customer ID.
     * @param customerID The ID of the customer to remove.
     */
    public void removeCustomer(int customerID) {
        Customer customer = findCustomerByID(customerID);
        if (customer == null) {
            System.out.println("Customer with ID " + customerID + " not found.");
        } else {
            customers.remove(customer);
            System.out.println("Customer removed successfully.");
        }
    }

    /**
     * Retrieves a customer from the bank by customer ID.
     * @param customerID The ID of the customer to retrieve.
     * @return The customer with the specified ID, or null if not found.
     */
    public Customer getCustomer(int customerID) {
        Customer customer = findCustomerByID(customerID);
        if (customer == null) {
            System.out.println("Customer with ID " + customerID + " not found.");
        }
        return customer;
    }

    /**
     * Adds an account to the bank.
     * @param account The account to add.
     */
    public void addAccount(Account account) {
        if (account == null) {
            System.out.println("Cannot add null account.");
            return;
        }
        if (accounts.contains(account)) {
            System.out.println("Account already exists.");
        } else {
            accounts.add(account);
            System.out.println("Account added successfully.");
        }
    }

    /**
     * Removes an account from the bank by account number.
     * @param accountNum The account number of the account to remove.
     */
    public void removeAccount(int accountNum) {
        Account account = findAccountByNumber(accountNum);
        if (account == null) {
            System.out.println("Account with number " + accountNum + " not found.");
        } else {
            accounts.remove(account);
            System.out.println("Account removed successfully.");
        }
    }

    /**
     * Retrieves an account from the bank by account number.
     * @param accountNum The account number of the account to retrieve.
     * @return The account with the specified account number, or null if not found.
     */
    public Account getAccount(int accountNum) {
        Account account = findAccountByNumber(accountNum);
        if (account == null) {
            System.out.println("Account with number " + accountNum + " not found.");
        }
        return account;
    }

    /**
     * Retrieves all customers from the bank.
     * @return A set containing all customers in the bank.
     */
    public Set<Customer> getAllCustomers() {
        return customers;
    }

    /**
     * Finds a customer in the bank by customer ID.
     * @param customerID The ID of the customer to find.
     * @return The customer with the specified ID, or null if not found.
     */
    private Customer findCustomerByID(int customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Finds an account in the bank by account number.
     * @param accountNum The account number of the account to find.
     * @return The account with the specified account number, or null if not found.
     */
    private Account findAccountByNumber(int accountNum) {
        for (Account account : accounts) {
            if (account.getAccountNum() == accountNum) {
                return account;
            }
        }
        return null;
    }

    /**
     * Displays details of all accounts in the bank.
     */
    public void displayAllAccounts() {
        System.out.println("All Accounts:");
        for (Account account : accounts) {
            account.displayDetails();
            System.out.println(); // Add a newline for separation
        }
    }

    /**
     * Displays transactions for a specific account.
     * @param accountNum The account number of the account to display transactions for.
     */
    public void displayAccountTransactions(int accountNum) {
        Account account = getAccount(accountNum);
        if (account != null) {
            System.out.println("Transactions for Account " + accountNum + ":");
            account.showTransactions();
        } else {
            System.out.println("Account with account number " + accountNum + " not found.");
        }
    }
}
