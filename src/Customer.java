import java.time.LocalDate;
import java.util.HashSet;


/**
 * Class for customer admin
 *
 * @author davem
 * @version 18/04/24
 */
public class Customer {

    public static int NEXT_CUSTOMER_ID = 1;

    private InputReader reader;
    private HashSet<Customer> customers;
    private int customerID;
    private String name;
    private String address;
    private String postcode;
    private int phoneNumber;
    private LocalDate dateOfBirth;


    /**
     * Constructor to create an object of the Customer Class
     *

     * @param aName        Customer name
     * @param aAddress     Customer address
     * @param aPostcode    Customer postcode
     * @param aPhoneNumber Customer phone number
     * @param aDob         Customer Date of Birth
     */
    public Customer(String aName, String aAddress, String aPostcode, int aPhoneNumber, LocalDate aDob) {
        customers = new HashSet<Customer>();
        this.customerID = NEXT_CUSTOMER_ID;
        NEXT_CUSTOMER_ID++;
        this.name = aName;
        this.address = aAddress;
        this.postcode = aPostcode;
        this.phoneNumber = aPhoneNumber;
        this.dateOfBirth = aDob;

    }

    /**
     * Getter for Customer ID field
     *
     * @return Customer ID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Getter for Name field
     *
     * @return Customer Name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for Address field
     *
     * @return Customer Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Getter for Postcode field
     *
     * @return Customer Postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Getter for Phone Number field
     *
     * @return Customer Phone Number
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Getter for Date of Birth field
     *
     * @return Customer Date of Birth
     */
    public LocalDate getDob() {
        return dateOfBirth;
    }

    /**
     * Getter method to access the list of customers.
     *
     * @return the list of customers
     */
    public HashSet<Customer> getCustomers() {
        return customers;
    }

    /**
     * Setter for Customer Name
     *
     * @param name Sets Customer Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for Customer Address
     *
     * @param address Sets Customer Address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Setter for Customer Postcode
     *
     * @param postcode Sets Customer Postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    /**
     * Setter for Customer Phone Number
     *
     * @param phoneNumber Sets Customer Phone Number
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Add customer to HashSet
     *
     * @param newCustomer Adds Customer to HashSet
     */
    public void addCustomer(Customer newCustomer) {
        customers.add(newCustomer);
    }

    /**
     * Remove customer from HashSet via Customer ID
     *
     * @param customerID the customer ID of the customer to remove
     */
    public void removeCustomer(int customerID) {
        if (customers.isEmpty()) {
            System.out.println("No customers to remove.");
            return; // Exit early if the set is empty
        }

        Customer customerToRemove = null;

        //For Loop to search through Customers
        for (Customer currentCustomer : customers) {
            // Find matching Customer ID
            if (currentCustomer.getCustomerID() == customerID) {
                customerToRemove = currentCustomer;
                break; // Stops searching when match is found
            }
        }

        // Remove the customer if found
        if (customerToRemove != null) {
            customers.remove(customerToRemove);
            System.out.println("Customer removed successfully.");
        }
        //if no match found
        else
        {
            System.out.println("Customer with ID " + customerID + " not found.");
        }
    }

    public Customer getCustomerById(int customerID) {
        // Assuming there is a HashSet<Customer> or another collection of customers named "customers"
        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                return customer;
            }
        }
        return null; // Return null if no customer is found
    }



        /**
         * Shows amount of customers in HashSet
         * @return amount of entries in Customer HashSet
         */
        private int getCustomerListSize () {
            if (customers != null) {
                return customers.size();
            } else {
                return 0; // Return 0 if customers list is null
            }
        }


        /**
         * Displays all Customers in HashSet
         */
        public void displayAllCustomers () {
            for (Customer customer : customers) {
                System.out.println("------------");
                System.out.println(customer);
            }
        }

        /**
         * @return
         */
        public String toString () {
            return "Customer ID: " + getCustomerID() + "\nName: " + this.getName() + "\nAddress: " + this.getAddress() +
                    "\nPostcode: " + getPostcode() + "\nPhone Number: " + getPhoneNumber() + "\nDate of Birth: " + getDob();
        }


    }
