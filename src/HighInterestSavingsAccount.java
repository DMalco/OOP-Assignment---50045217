import java.time.LocalDate;

public class HighInterestSavingsAccount extends Account
{
    private int interestRate;
    public HighInterestSavingsAccount(int aAccountNum, int aSortCode, String anAccountOwner, int aAccountBalance, LocalDate aOpenDate, LocalDate theCloseDate, int theClosingBalance, int aInterestRate)
    {
        super(/*aAccountNum,*/ aSortCode, anAccountOwner, aAccountBalance, aOpenDate,theCloseDate,theClosingBalance);
        this.interestRate = aInterestRate;
    }
}
