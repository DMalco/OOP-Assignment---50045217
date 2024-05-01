import java.time.LocalDate;

public class SavingsAccount extends Account
{
    private int interestRate;
    public SavingsAccount(int aAccountNum, int aSortCode, String anAccountOwner, int aAccountBalance, LocalDate aOpenDate, LocalDate theCloseDate, int theClosingBalance, int aInterestRate)
    {
        super(/*aAccountNum*/aSortCode, anAccountOwner, aAccountBalance, aOpenDate,theCloseDate,theClosingBalance);
        this.interestRate = aInterestRate;
    }
}
