/**
 * Provides a User Interface for bank application
 * @author davem
 * @version 17/04/24
 */
public class UserInterface {
    private InputReader reader;

    public UserInterface() {
        reader = new InputReader();
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
            System.out.println("2. Display Customer Details");
            System.out.println("3. Open Account");
            System.out.println("4. Close Account");
            System.out.println("5. Deposit");
            System.out.println("6. Withdrawal");
            System.out.println("7. Display All Customers");
            System.out.println("8. Display All Accounts");
            System.out.println("9. Display Account Transactions");
            System.out.println("0. Exit Application");

            String userInput = reader.getInput();


            switch (userInput) {
                case "1":
                    //Add Customer
                    break;
                case "2":
                    //Display Customer Details
                    break;
                case "3":
                    //Open Account
                    break;
                case "4":
                    //Close Account
                    break;
                case "5":
                    //Deposit
                    break;
                case "6":
                    //Withdraw
                    break;
                case "7":
                    //Display All Customers
                case "8":
                    //Display All Accounts
                    break;
                case "9":
                    //Display Account Transactions
                    break;
                //Exit
                case "0":
                    quit = true;
                    break;
                    //Catch
                default:
                    System.out.println("Sorry, that is not a valid choice, please try again:\n");
                    break;

            }
        }
    }
}

