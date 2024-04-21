import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Provides a User Interface for bank application
 *
 * @author davem
 * @version 17/04/24
 */
public class UserInterface {

    public Customer customer;
    private InputReader reader;


    public UserInterface() {
        reader = new InputReader();

        customer = null;
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
                    //Display Customer Details
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
        System.out.println("Please enter Customer ID: ");
        int customerID = reader.getIntInput();
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

        Customer newCustomer = new Customer(customerID, name, address, postcode, phoneNumber, dateOfBirth);

        if (customer == null) {
            customer = new Customer(customerID, name, address, postcode, phoneNumber, dateOfBirth);
        }

        customer.addCustomer(newCustomer);
        System.out.println("Customer added successfully.\n");
    }

    public void removeCustomer() {
        System.out.println("Remove Customer");
        System.out.println("Enter the Customer ID to remove: ");
        int customerID = reader.getIntInput(); // Read the customer ID from the user

        if (customer != null) {
            customer.removeCustomer(customerID); // Call the removeCustomer method on the customer object
        } else {
            System.out.println("No customers available to remove.\n");
        }
    }

    public void updateCustomerDetails() {
        System.out.println("Update Customer Details");
        System.out.println("Enter the Customer ID to update: ");
        int customerID = reader.getIntInput();

        //If customer list is empty
        if (customer == null || customer.getCustomerListSize() == 0) {
            System.out.println("No customers available.");
            return;
        }

        //Only way I could find to be able to use customer Array List
        List<Customer> customers = customer.getCustomers();

        // Find customer with Customer ID
        Customer customerToUpdate = null;
        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                customerToUpdate = customer;
                break;
            }
        }

        //Confirmation message
        if (customerToUpdate == null) {
            System.out.println("Customer with ID " + customerID + " not found.");
            return;
        }

        // Display update menu until finished
        boolean exit = false;
        while (!exit) {
            System.out.println("Update Customer Details");
            System.out.println("Select detail to update: ");
            System.out.println("1. Update Name - " + customer.getName());
            System.out.println("2. Update Address - " + customer.getAddress());
            System.out.println("3. Update Postcode - " + customer.getPostcode());
            System.out.println("4. Update Phone Number - " + customer.getPhoneNumber());
            System.out.println("5. Return to Main Menu");

            // Read user input for the option to update
            String option = reader.getStringInput();

            // Perform the update based on the chosen option
            switch (option) {
                case "1":
                    System.out.print("Enter new name: ");
                    String newName = reader.getStringInput();
                    customerToUpdate.setName(newName);
                    System.out.println("Customer name updated successfully.");
                    break;
                case "2":
                    System.out.print("Enter new address: ");
                    String newAddress = reader.getStringInput();
                    customerToUpdate.setAddress(newAddress);
                    System.out.println("Customer address updated successfully.");
                    break;
                case "3":
                    System.out.print("Enter new postcode: ");
                    String newPostcode = reader.getStringInput();
                    customerToUpdate.setPostcode(newPostcode);
                    System.out.println("Customer postcode updated successfully.");
                    break;
                case "4":
                    System.out.print("Enter new phone number: ");
                    int newPhoneNumber = reader.getIntInput();
                    customerToUpdate.setPhoneNumber(newPhoneNumber);
                    System.out.println("Customer phone number updated successfully.");
                    break;
                case "5":
                    exit = true;
                    showMainMenu();

                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }

        }
    }


    public void listAllCustomers() {
        if (customer != null) {
            customer.displayAllCustomers();
            System.out.println();
        } else {
            System.out.println("No customers to display.\n");
        }
    }

}

