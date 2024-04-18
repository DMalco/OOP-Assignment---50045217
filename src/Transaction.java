import java.time.LocalDate;

/**
 * Class for Transaction admin
 * @author davem
 * @version 18/04/24
 */
public class Transaction {
    private int transactionID;
    private int accountNum;
    private LocalDate transactionDate;
    private String type; //Deposit/withdrawal
    private int amount;
}
