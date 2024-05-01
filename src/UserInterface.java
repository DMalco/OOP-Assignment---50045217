import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.List;

/**
 * Provides a User Interface for bank application
 *
 * @author davem
 * @version 17/04/24
 */
public class UserInterface {
    private HashSet<Customer> customers;

    private Customer customer;
    private InputReader reader;

    public UserInterface() {
        reader = new InputReader();

        customers = new HashSet<>();
    }


    /**
     * Will show Main Menu until user selects to quit application
     */
    public void showMainMenu() {
        boolean quit = false;

        while (!quit) {
            System.out.println("Kilmaine Credit Union");
            System.out.println("**********************");
            System.out.println("Please choose option:");
            System.out.println("1. Add Customer");
            System.out.println("2. Remove Customer");
            System.out.println("3. Display Customer Details");
            System.out.println("4. Open Account");
            System.out.println("5. Close Account");
            System.out.println("6. Deposit");
            System.out.println("7. Withdrawal");
            System.out.println("8. Display All Customers");
            System.out.println("9. Display All Accounts");
            System.out.println("10. Display Account Transactions");
            System.out.println("0. Exit Application");

            String userInput = reader.getStringInput();


            switch (userInput) {
                case "1":
                    //Add Customer
                    this.addCustomer();
                    break;
                case "2":
                    //Remove Customer
                    removeCustomer();
                    break;
                case "3":
                    updateCustomerDetails();
                    //UPDATE!!/Display Customer Details
                    break;
                case "4":
                    //Open Account
                    break;
                case "5":
                    //Close Account
                    break;
                case "6":
                    //Deposit
                    break;
                case "7":
                    //Withdraw
                case "8":
                    listAllCustomers();
                    //Display All Customers
                    break;
                case "9":
                    //Display All Accounts
                    break;
                case "10":
                    //Display Account Transactions
                    //Exit
                case "0":
                    System.out.println("Thank you for using Kilmaine Credit Union. Goodbye!");
                    quit = true;
                    break;
                //Catch
                default:
                    System.out.println("Invalid Menu Selection. Please try again:\n");
                    break;

            }
        }
    }

    public void addCustomer() {
        System.out.println("Create New Customer");
        System.out.println("--------------------");
        System.out.println("Please enter Customer Name: ");
        String name = reader.getStringInput();
        System.out.println("Please enter Customer Address: ");
        String address = reader.getStringInput();
        System.out.println("Please enter Customer Postcode: ");
        String postcode = reader.getStringInput();
        System.out.println("Please enter Customer Phone Number: ");
        int phoneNumber = reader.getIntInput();

        System.out.println("Please enter Customer Date of Birth [DD/MM/YYYY]: ");
        String dob = reader.getStringInput();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = null;
        try {
            dateOfBirth = LocalDate.parse(dob, dtf);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter a date in the format [DD/MM/YYYY].");
            return;
        }

        // Create a new customer
        Customer newCustomer = new Customer(name, address, postcode, phoneNumber, dateOfBirth);

        // Add the new customer to the HashSet
        if (customers.add(newCustomer)) {
            System.out.println("Customer added successfully.");
        } else {
            System.out.println("Customer already exists.");
        }
    }

    public void removeCustomer() {
        System.out.println("Remove Customer");
        System.out.println("Enter the Customer ID to remove: ");
        int customerID = reader.getIntInput(); // Read the customer ID from the user

        // Find and remove the customer from the HashSet
        Customer customerToRemove = findCustomerById(customerID);
        if (customerToRemove != null) {
            customers.remove(customerToRemove);
            System.out.println("Customer removed successfully.");
        } else {
            System.out.println("Customer with ID " + customerID + " not found.");
        }
    }

    // Define a method to find a customer by ID
    private Customer findCustomerById(int customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                return customer;
            }
        }
        return null; // Return null if customer is not found
    }

    public void updateCustomerDetails() {
        System.out.println("Update Customer Details");
        System.out.println("Enter the Customer ID to update: ");
        int customerID = reader.getIntInput();

        // Find the customer to update using the HashSet
        Customer customerToUpdate = findCustomerById(customerID);

        if (customerToUpdate == null) {
            System.out.println("Customer with ID " + customerID + " not found.");
            return;
        }

        // Allow the user to update customer details
        System.out.println("Updating details for Customer ID: " + customerID);
        System.out.println("1. Update Name (current: " + customerToUpdate.getName() + ")");
        System.out.println("2. Update Address (current: " + customerToUpdate.getAddress() + ")");
        System.out.println("3. Update Postcode (current: " + customerToUpdate.getPostcode() + ")");
        System.out.println("4. Update Phone Number (current: " + customerToUpdate.getPhoneNumber() + ")");
        System.out.println("0. Return to Main Menu");

        String choice = reader.getStringInput();

        switch (choice) {
            case "1":
                System.out.println("Enter new name:");
                String newName = reader.getStringInput();
                customerToUpdate.setName(newName);
                System.out.println("Customer name updated successfully.");
                break;
            case "2":
                System.out.println("Enter new address:");
                String newAddress = reader.getStringInput();
                customerToUpdate.setAddress(newAddress);
                System.out.println("Customer address updated successfully.");
                break;
            case "3":
                System.out.println("Enter new postcode:");
                String newPostcode = reader.getStringInput();
                customerToUpdate.setPostcode(newPostcode);
                System.out.println("Customer postcode updated successfully.");
                break;
            case "4":
                System.out.println("Enter new phone number:");
                int newPhoneNumber = reader.getIntInput();
                customerToUpdate.setPhoneNumber(newPhoneNumber);
                System.out.println("Customer phone number updated successfully.");
                break;
            case "0":
                // Return to main menu
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    /**
     * Display all customers and details
     */
    public void listAllCustomers() {
        customer.displayAllCustomers();
    }

    /*

    Account Methods
    ---------------------------------------------------------------------------------------

     */



}