import java.time.LocalDate;

/**
 * CurrentAccount Class extends Account
 */
public class CurrentAccount extends Account {

    /**
     * Constructor to create a CurrentAccount object.
     * @param anAccountOwner The customer who owns the account.
     */
    public CurrentAccount(Customer anAccountOwner) {
        super(anAccountOwner);
    }

}