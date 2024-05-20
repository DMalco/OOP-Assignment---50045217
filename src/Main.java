/**
 * Main class to start the application.
 * @author [DMalco]
 * @version [20/05/24]
 */
public class Main {
    /**
     * Main method to start the application.
     * It creates an instance of the UserInterface class and calls the showMainMenu method to display the main menu.

     */
    public static void main(String[] args) {
        UserInterface ui = new UserInterface(); // Create UserInterface object
        ui.showMainMenu(); // Show main menu
    }
}