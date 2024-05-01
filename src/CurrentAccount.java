import java.time.LocalDate;

public class CurrentAccount extends Account
{


    public CurrentAccount(int aSortCode, String anAccountOwner, int aAccountBalance, LocalDate aOpenDate, LocalDate theCloseDate, int theClosingBalance)
    {
        super(aSortCode, anAccountOwner, aAccountBalance, aOpenDate,theCloseDate,theClosingBalance);


    }
}
