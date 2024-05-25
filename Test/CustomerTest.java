import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.Assert.*;

public class CustomerTest {
    private Customer customer;
    private Customer anotherCustomer;

    @Before
    public void setUp() {
        // Initialize a Customer instance before each test
        customer = new Customer("John Doe", "123 Main St", "AB12 3CD", 1234567890, LocalDate.of(1990, 1, 1));
        anotherCustomer = new Customer("Jane Smith", "456 Elm St", "EF45 6GH", 987654321, LocalDate.of(1992, 2, 2));
    }

    @Test
    public void testGetCustomerID() {
        // Check if the customer ID is initialized correctly
        assertEquals(1, customer.getCustomerID());
    }

    @Test
    public void testGetName() {
        // Check if the customer name is initialized correctly
        assertEquals("John Doe", customer.getName());
    }

    @Test
    public void testGetAddress() {
        // Check if the customer address is initialized correctly
        assertEquals("123 Main St", customer.getAddress());
    }

    @Test
    public void testGetPostcode() {
        // Check if the customer postcode is initialized correctly
        assertEquals("AB12 3CD", customer.getPostcode());
    }

    @Test
    public void testGetPhoneNumber() {
        // Check if the customer phone number is initialized correctly
        assertEquals(1234567890, customer.getPhoneNumber());
    }

    @Test
    public void testGetDob() {
        // Check if the customer date of birth is initialized correctly
        assertEquals(LocalDate.of(1990, 1, 1), customer.getDob());
    }

    @Test
    public void testGetCustomers() {
        // Check if the customers set is initialized correctly
        assertNotNull(customer.getCustomers());
    }

    @Test
    public void testSetName() {
        // Set a new name and check if it is updated correctly
        customer.setName("New Name");
        assertEquals("New Name", customer.getName());
    }

    @Test
    public void testSetAddress() {
        // Set a new address and check if it is updated correctly
        customer.setAddress("New Address");
        assertEquals("New Address", customer.getAddress());
    }

    @Test
    public void testSetPostcode() {
        // Set a new postcode and check if it is updated correctly
        customer.setPostcode("ZZ99 9ZZ");
        assertEquals("ZZ99 9ZZ", customer.getPostcode());
    }

    @Test
    public void testSetPhoneNumber() {
        // Set a new phone number and check if it is updated correctly
        customer.setPhoneNumber(1122334455);
        assertEquals(1122334455, customer.getPhoneNumber());
    }

    @Test
    public void testAddCustomer() {
        // Add another customer and check if the size of the customers set is updated correctly
        customer.addCustomer(anotherCustomer);
        assertEquals(1, customer.getCustomerListSize());
    }

    @Test
    public void testRemoveCustomer() {
        // Add and then remove another customer and check if the size of the customers set is updated correctly
        customer.addCustomer(anotherCustomer);
        customer.removeCustomer(anotherCustomer.getCustomerID());
        assertEquals(0, customer.getCustomerListSize());
    }

    @Test
    public void testGetCustomerById() {
        // Add another customer and check if it can be retrieved by its ID
        customer.addCustomer(anotherCustomer);
        assertEquals(anotherCustomer, customer.getCustomerById(anotherCustomer.getCustomerID()));
    }

    @Test
    public void testGetCustomerListSize() {
        // Check if the customer list size is updated correctly
        assertEquals(0, customer.getCustomerListSize());
        customer.addCustomer(anotherCustomer);
        assertEquals(1, customer.getCustomerListSize());
    }

    @Test
    public void testDisplayAllCustomers() {
        // Capture console output
        ByteArrayOutputStream output = captureOutput();

        // Add another customer and display all customers
        customer.addCustomer(anotherCustomer);
        customer.displayAllCustomers();

        // Validate the output
        String expectedOutput = "------------\n" + anotherCustomer.toString() + "\n";
        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testDisplayDetails() {
        // Capture console output
        ByteArrayOutputStream output = captureOutput();

        // Display customer details
        customer.displayDetails();

        // Validate the output
        String expectedOutput = customer.getCustomerID() + "\t" + customer.getName() + "\t" + customer.getAddress() + "\t" + customer.getPostcode() + "\t" + customer.getDob().toString() + "\n";
        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testToString() {
        // Check if the string representation of the customer is correct
        String expectedString = "Customer ID: " + customer.getCustomerID() + ", Name: " + customer.getName() + ", Address: " + customer.getAddress() + ", Postcode: " + customer.getPostcode() + ", Date of Birth: " + customer.getDob().toString();
        assertEquals(expectedString, customer.toString());
    }

    @Test
    public void testEquals() {
        // Create a new customer with the same ID
        Customer sameCustomer = new Customer("John Doe", "123 Main St", "AB12 3CD", 1234567890, LocalDate.of(1990, 1, 1)) {
            @Override
            public int getCustomerID() {
                return customer.getCustomerID();
            }
        };

        // Check if the two customers are equal
        assertTrue(customer.equals(sameCustomer));
    }

    // Method to capture console output
    private ByteArrayOutputStream captureOutput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }
}
