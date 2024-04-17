public class UserInterface {
    private InputReader reader;

    public UserInterface() {
        reader = new InputReader();
    }

    public void showMainMenu() {
        boolean quit = false;

        while (!quit) {
            System.out.println("Please choose option:");
            System.out.println("1. Add Customer");
            System.out.println("2. Display Customer Details");
            System.out.println("3. Open Account");
            System.out.println("4. Close Account");
            System.out.println("5. Deposit");
            System.out.println("6. Withdrawal");
            System.out.println("7. Display All Customers");
            System.out.println("8. Display All Accounts");
            System.out.println("9. Account Transactions");
            System.out.println("0. Exit Application");

            String userInput = reader.getInput();

            /*
             *             switch (userInput) {
             *                 case "1":
             *                     this.addBook();
             *                     break;
             *                 case "2":
             *                     this.listBooks();
             *                     break;
             *                 case "0":
             *                     quit = true;
             *                     break;
             *                 default:
             *                     System.out.println("Sorry, that is not a valid choice, please try again:\n");
             *                     break;
             */
        }
    }
}

