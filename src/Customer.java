import java.time.LocalDate;
import java.util.HashSet;

/**
 * Class representing a customer in the bank system.
 */
public class Customer {

    public static int NEXT_CUSTOMER_ID = 1;

    private HashSet<Customer> customers;
    private int customerID;
    private String name;
    private String address;
    private String postcode;
    private int phoneNumber;
    private LocalDate dateOfBirth;

    /**
     * Constructor to create a Customer object.
     *
     * @param aName        Customer name
     * @param aAddress     Customer address
     * @param aPostcode    Customer postcode
     * @param aPhoneNumber Customer phone number
     * @param aDob         Customer Date of Birth
     */
    public Customer(String aName, String aAddress, String aPostcode, int aPhoneNumber, LocalDate aDob) {
        this.customers = new HashSet<>();
        this.customerID = NEXT_CUSTOMER_ID;
        NEXT_CUSTOMER_ID++;
        this.name = aName;
        this.address = aAddress;
        this.postcode = aPostcode;
        this.phoneNumber = aPhoneNumber;
        this.dateOfBirth = aDob;
    }

    /**
     * Getter for Customer ID field.
     *
     * @return Customer ID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Getter for Name field.
     *
     * @return Customer Name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for Address field.
     *
     * @return Customer Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Getter for Postcode field.
     *
     * @return Customer Postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Getter for Phone Number field.
     *
     * @return Customer Phone Number
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Getter for Date of Birth field.
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
     * Setter for Customer Name.
     *
     * @param name Sets Customer Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for Customer Address.
     *
     * @param address Sets Customer Address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Setter for Customer Postcode.
     *
     * @param postcode Sets Customer Postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * Setter for Customer Phone Number.
     *
     * @param phoneNumber Sets Customer Phone Number
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Adds a customer to the HashSet of customers.
     *
     * @param newCustomer The customer to be added
     */
    public void addCustomer(Customer newCustomer) {
        customers.add(newCustomer);
    }

    /**
     * Removes a customer from the HashSet based on their ID.
     *
     * @param customerID The ID of the customer to remove
     */
    public void removeCustomer(int customerID) {
        if (customers.isEmpty()) {
            System.out.println("No customers to remove.");
            return; // Exit early if the set is empty
        }

        Customer customerToRemove = null;

        // Iterate through customers to find matching ID
        for (Customer currentCustomer : customers) {
            if (currentCustomer.getCustomerID() == customerID) {
                customerToRemove = currentCustomer;
                break; // Stops searching when match is found
            }
        }

        // Remove the customer if found
        if (customerToRemove != null) {
            customers.remove(customerToRemove);
            System.out.println("Customer removed successfully.");
        } else {
            System.out.println("Customer with ID " + customerID + " not found.");
        }
    }

    /**
     * Retrieves a customer by their ID.
     *
     * @param customerID The ID of the customer to retrieve
     * @return The customer object if found, null otherwise
     */
    public Customer getCustomerById(int customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Shows the number of customers in the HashSet.
     *
     * @return The number of entries in the Customer HashSet
     */
    private int getCustomerListSize() {
        if (customers != null) {
            return customers.size();
        } else {
            return 0; // Return 0 if customers list is null
        }
    }

    /**
     * Displays details of all customers in the HashSet.
     */
    public void displayAllCustomers() {
        for (Customer customer : customers) {
            System.out.println("------------");
            System.out.println(customer);
        }
    }

    /**
     * Displays details of a customer.
     */
    public void displayDetails() {
        System.out.println(this.getCustomerID() + "\t" + this.getName() + "\t" + this.getAddress() + "\t" + this.getPostcode()
                + "\t" + this.getDob().toString());
    }

    /**
     * Overrides the toString method to provide a string representation of the Customer object.
     *
     * @return A string representation of the Customer object
     */
    @Override
    public String toString() {
        return "Customer ID: " + this.getCustomerID() + ", Name: " + this.getName() + ", Address: " + this.getAddress() + ", Postcode: " + this.getPostcode() + ", Date of Birth: " + this.getDob().toString();
    }

    @Override
    public boolean equals(Object obj)
    {

        boolean equal = false; // local variable to use to return whether the objects are considered equal
        if (obj == this) // if memory references of the two objects match, we consider them equal by default
        {
            equal = true;
        }
        else // memory references do not match
        {
            if(obj instanceof  Customer) // if parameter object is an instance of the visitor class (or its subclasses)
            {
                Customer otherCustomer = (Customer) obj; // cast the parameter object to an object of the Visitor class

                if(otherCustomer.getCustomerID() == this.getCustomerID()) // compare the IDs
                {
                    equal = true; // return true if the IDs match
                }
            }
        }

        return equal;
    }

}
