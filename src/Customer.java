import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for customer admin
 *
 * @author davem
 * @version 18/04/24
 */
public class Customer {

    private InputReader reader;
    private ArrayList<Customer> customers;
    private int customerID;
    private String name;
    private String address;
    private String postcode;
    private int phoneNumber;
    private LocalDate dateOfBirth;


    /**
     * Constructor to create an object of the Customer Class
     *
     * @param aCustomerID  unique Customer ID
     * @param aName        Customer name
     * @param aAddress     Customer address
     * @param aPostcode    Customer postcode
     * @param aPhoneNumber Customer phone number
     * @param aDob         Customer Date of Birth
     */
    public Customer(int aCustomerID, String aName, String aAddress, String aPostcode, int aPhoneNumber, LocalDate aDob) {
        customers = new ArrayList<Customer>();
        this.customerID = aCustomerID;
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
    public List<Customer> getCustomers() {
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
     * Add customer to Array List
     *
     * @param newCustomer Adds Customer to Array List
     */
    public void addCustomer(Customer newCustomer) {
        customers.add(newCustomer);
    }

    public void removeCustomer(int customerID) {
        if (customers.isEmpty()) {
            System.out.println("No customers to remove.");
            return; // Exit the method early if the list is empty
        }

        // Search for the customer with the given ID
        int indexToRemove = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerID() == customerID) {
                indexToRemove = i;
                break;
            }
        }

        // Remove the customer if found
        if (indexToRemove != -1) {
            customers.remove(indexToRemove);
            System.out.println("Customer removed successfully.");
        } else {
            System.out.println("Customer with ID " + customerID + " not found.");
        }
    }



    public int getCustomerListSize() {
        if (customers != null) {
            return customers.size();
        } else {
            return 0; // Return 0 if customers list is null
        }
    }



    /**
     * Displays all Customers in Array List
     */
    public void displayAllCustomers() {
        for (Customer customer : customers) {
            System.out.println("------------");
            System.out.println(customer);
        }
    }

    /**
     * @return
     */
    public String toString() {
        return "Customer ID: " + getCustomerID() + "\nName: " + this.getName() + "\nAddress: " + this.getAddress() +
                "\nPostcode: " + getPostcode() + "\nPhone Number: " + getPhoneNumber() + "\nDate of Birth: " + getDob();
    }


}
