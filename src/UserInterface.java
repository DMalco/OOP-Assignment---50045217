import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * User Interface Class
 * Handles user interaction and menu display for the banking application.
 * Allows users to perform various operations such as adding customers, opening/closing accounts, and conducting transactions.
 */
public class UserInterface {
    private final Bank bank;
    private final InputReader reader;

    /**
     * Constructor to initialize UserInterface object with a bank and input reader.
     */
    public UserInterface() {
        this.bank = new Bank();
        this.reader = new InputReader();
    }

    /**
     * Displays the main menu and handles user input for menu options.
     * Continues to display the menu until the user chooses to exit.
     */
    public void showMainMenu() {
        boolean quit = false;

        while (!quit) {
            System.out.println("\nKilmaine Credit Union");
            System.out.println("**********************");
            System.out.println("Please choose option:");
            System.out.println("1. Add Customer");
            System.out.println("2. Remove Customer");
            System.out.println("3. Display Customer Details");
            System.out.println("4. Update Customer Details");
            System.out.println("5. Open Account");
            System.out.println("6. Close Account");
            System.out.println("7. Deposit");
            System.out.println("8. Withdrawal");
            System.out.println("9. Display All Customers");
            System.out.println("10. Display All Accounts");
            System.out.println("11. Display Account Transactions");
            System.out.println("0. Exit Application");

            //user input
            String userInput = reader.getStringInput();

            switch (userInput) {
                case "1":
                    //Add new customer
                    addCustomer();
                    break;
                case "2":
                    //Delete Customer records
                    removeCustomer();
                    break;
                case "3":
                    //Display individual Customer details
                    displayCustomerDetails();
                    break;
                case "4":
                    //Update Customer Details
                    updateCustomerDetails();
                    break;
                case "5":
                    // Open Account
                    openAccount();
                    break;
                case "6":
                    // Close Account
                    closeAccount();
                    break;
                case "7":
                    // Deposit
                    deposit();
                    break;
                case "8":
                    // Withdraw
                    withdraw();
                    break;
                case "9":
                    listAllCustomers();
                    break;
                case "10":
                    // Display All Accounts
                    bank.displayAllAccounts();
                    break;
                case "11":
                    // Display Account Transactions#
                    System.out.println("Enter the account number to display transactions:");
                    int accountNum = reader.getIntInput();
                    bank.displayAccountTransactions(accountNum);
                    break;
                case "0":
                    System.out.println("Thank you for using Kilmaine Credit Union. Goodbye!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid Menu Selection. Please try again:\n");
                    break;
            }
        }
    }

    /**
     * Adds customer to bank records via user input
     * Try/catch to ensure correct date input format
     */
    public void addCustomer() {
        System.out.println("Create New Customer");
        System.out.println("--------------------");
        System.out.println("Please enter Customer Name: ");
        String name = reader.getStringInput();
        System.out.println("Please enter Customer Address: ");
        String address = reader.getStringInput();
        System.out.println("Please enter Customer Postcode: ");
        String postcode = reader.getStringInput();

        int phoneNumber = 0;
        boolean validPhoneNumber = false;
        while (!validPhoneNumber) {
            System.out.println("Please enter Customer Phone Number: ");
            try {
                phoneNumber = Integer.parseInt(reader.getStringInput());
                validPhoneNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Phone number must be a number.");
            }
        }


        LocalDate dateOfBirth = null;

        while (dateOfBirth == null) {
            System.out.println("Please enter Customer Date of Birth [DD/MM/YYYY]: ");
            String dob = reader.getStringInput();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            //To make sure date is inputted correctly
            try {
                dateOfBirth = LocalDate.parse(dob, dtf);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a date in the format [DD/MM/YYYY]: ");
            }
        }

        Customer newCustomer = new Customer(name, address, postcode, phoneNumber, dateOfBirth);
        bank.addCustomer(newCustomer);
        // Print the details of the newly added customer
        System.out.println("New Customer Added:");
        System.out.println("Customer ID: " + newCustomer.getCustomerID());
        System.out.println("Name: " + newCustomer.getName());
        System.out.println("Address: " + newCustomer.getAddress());
        System.out.println("Postcode: " + newCustomer.getPostcode());
        System.out.println("Phone Number: " + newCustomer.getPhoneNumber());
        System.out.println("Date of Birth: " + newCustomer.getDob());
    }

    /**
     * Remove customer from bank records. Searched by unique Customer ID
     */
    private void removeCustomer() {
        System.out.println("Remove Customer");
        System.out.println("Enter the Customer ID to remove: ");
        int customerID = reader.getIntInput();

        bank.removeCustomer(customerID);
    }

    /**
     * Display all details for individual customer by searching for their Customer ID
     */
    private void displayCustomerDetails() {
        System.out.println("Enter the Customer ID to display details: ");
        int customerID = reader.getIntInput();

        Customer customer = bank.getCustomer(customerID);
        if (customer != null) {
            System.out.println(customer);
        }
    }

    /**
     * Update existing customer details by searching for their Customer ID and selecting which details to change
     */
    private void updateCustomerDetails() {
        System.out.println("Update Customer Details");
        System.out.println("Enter the Customer ID to update: ");
        int customerID = reader.getIntInput();

        Customer customerToUpdate = bank.getCustomer(customerID);

        if (customerToUpdate == null) {
            System.out.println("Customer with ID " + customerID + " not found.");
            return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("Updating details for Customer ID: " + customerID);
            System.out.println("1. Update Name (current: " + customerToUpdate.getName() + ")"); // Will show updated details when changed
            System.out.println("2. Update Address (current: " + customerToUpdate.getAddress() + ")");
            System.out.println("3. Update Postcode (current: " + customerToUpdate.getPostcode() + ")");
            System.out.println("4. Update Phone Number (current: " + customerToUpdate.getPhoneNumber() + ")");
            System.out.println("0. Exit Update Menu");

            String userInput = reader.getStringInput();

            switch (userInput) {
                case "1":
                    System.out.println("Enter new name: ");
                    customerToUpdate.setName(reader.getStringInput());
                    break;
                case "2":
                    System.out.println("Enter new address: ");
                    customerToUpdate.setAddress(reader.getStringInput());
                    break;
                case "3":
                    System.out.println("Enter new postcode: ");
                    customerToUpdate.setPostcode(reader.getStringInput());
                    break;
                case "4":
                    System.out.println("Enter new phone number: ");
                    customerToUpdate.setPhoneNumber(reader.getIntInput());
                    break;
                case "0":
                    System.out.println("Exiting update menu.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        System.out.println("Customer details updated successfully.");
    }

    /**
     * Displays all Customer records
     */
    private void listAllCustomers() {
        System.out.println("List of All Customers:");
        for (Customer customer : bank.getAllCustomers()) {
            System.out.println(customer);
        }
    }


    /**
     * Opens account with bank search via customer ID
     * Select type of account to open via switch statement
     */
    private void openAccount() {
        System.out.println("Open Account");
        System.out.println("Enter the Customer ID to open account for: ");
        int customerID = reader.getIntInput();

        // Find the customer
        Customer customer = bank.getCustomer(customerID);

        if (customer == null) {
            System.out.println("Customer with ID " + customerID + " not found.");
            return;
        }

        System.out.println("Choose account type:");
        System.out.println("1. Current Account");
        System.out.println("2. Savings Account");
        System.out.println("3. High Interest Savings Account");
        System.out.println("Enter your choice: ");
        int choice = reader.getIntInput();

        Account account;

        switch (choice) {
            case 1:
                account = new CurrentAccount(customer);
                break;
            case 2:
                account = new SavingsAccount(customer);
                break;
            case 3:
                account = new HighInterestSavingsAccount(customer);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                return;
        }

        // Activate the account
        account.activate();

        // Add the account to the bank
        bank.addAccount(account);

        System.out.println("Account opened successfully.");
        System.out.println("Account Holder: " + bank.getCustomer(customerID) +
                "\n Account Number: " + account.getAccountNum() + " Balance: " + account.getBalance());

    }

    /**
     * Close account and record date of closure and closing balance
     */
    private void closeAccount() {
        System.out.println("Close Account");
        System.out.println("Enter the Account Number to close: ");
        int accountNum = reader.getIntInput();

        // Find the account to close using the HashSet
        Account account = bank.getAccount(accountNum);

        if (account == null) {
            System.out.println("Account with number " + accountNum + " not found.");
            return;
        }

        // Check if the account is already closed
        if (!account.isActive()) {
            System.out.println("Account is already closed.");
            return;
        }

        // Close the account
        account.deactivate();
        System.out.println("Account closed successfully.");
        System.out.println("Closing Date: " + LocalDate.now());
        System.out.println("Closing Balance: " + account.getBalance());
    }


    /**
     * Deposit money into an account, search for account via Account Number
     */
    public void deposit() {
        System.out.println("Deposit Into Account");
        System.out.println("Enter the Account Number to deposit into: ");
        int accountNum = reader.getIntInput();

        // Find the account
        Account account = bank.getAccount(accountNum);

        if (account == null) {
            System.out.println("Account with number " + accountNum + " not found.");
            return;
        }

        // Check if the account is closed
        if (!account.isActive()) {
            System.out.println("Cannot deposit into a closed account.");
            return; // Exit the method if the account is closed
        }

        // Check if the account is a high-interest savings account and if it has reached the transaction limit
        if (account instanceof HighInterestSavingsAccount) {
            HighInterestSavingsAccount highInterestAccount = (HighInterestSavingsAccount) account;
            if (highInterestAccount.getTransactionsThisYear() >= highInterestAccount.getTransactionLimit()) {
                System.out.println("Transaction limit for the year reached.");
                return; // Exit the method if the transaction limit is reached
            }
        }

        System.out.println("Enter the amount to deposit: ");
        int amount = reader.getIntInput();

        // Create a transaction object for the deposit
        Transaction depositTransaction = new Transaction(TransactionType.DEPOSIT, amount);

        // Add the transaction to the account
        account.addTransaction(depositTransaction);

        // Update the account balance
        account.deposit(amount);

        // Print success message with new balance
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }

    /**
     * Withdraw money from an account, search for account via Account Number
     */
    public void withdraw() {
        System.out.println("Withdraw From Account");
        System.out.println("Enter the Account Number to withdraw from: ");
        int accountNum = reader.getIntInput();

        // Find the account
        Account account = bank.getAccount(accountNum);

        if (account == null) {
            System.out.println("Account with number " + accountNum + " not found.");
            return;
        }

        // Check if the account is closed
        if (!account.isActive()) {
            System.out.println("Cannot withdraw from a closed account.");
            return; // Exit the method if the account is closed
        }

        // Check if the account is a high-interest savings account and if it has reached the transaction limit
        if (account instanceof HighInterestSavingsAccount) {
            HighInterestSavingsAccount highInterestAccount = (HighInterestSavingsAccount) account;
            if (highInterestAccount.getTransactionsThisYear() >= highInterestAccount.getTransactionLimit()) {
                System.out.println("Transaction limit for the year reached.");
                return; // Exit the method if the transaction limit is reached
            }
        }

        System.out.println("Enter the amount to withdraw: ");
        int amount = reader.getIntInput();

        // Check if the account balance is sufficient
        if (amount > account.getBalance()) {
            System.out.println("Insufficient funds.");
            return;
        }

        // Create a transaction object for the withdrawal
        Transaction withdrawalTransaction = new Transaction(TransactionType.WITHDRAW, amount);

        // Add the transaction to the account
        account.addTransaction(withdrawalTransaction);

        // Update the account balance
        account.withdraw(amount);

        // Print success message with new balance
        System.out.println("Withdrawal successful. New balance: " + account.getBalance());
    }



}
