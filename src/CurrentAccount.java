import java.time.LocalDate;
/**
 * Represents a current account.
 */
public class CurrentAccount extends Account {

    /**
     * Constructor to create a CurrentAccount object.
     * @param anAccountOwner The customer who owns the account.
     */

    public CurrentAccount(Customer anAccountOwner) {
        super(anAccountOwner);
    }

    /**
     * Returns the account type as "Current Account".
     * @return the account type.
     */
    @Override
    public String getAccountType() {
        return "Current Account";
    }
}
