import java.time.LocalDate;

/**
 * Class for Account admin
 * @author davem
 * @version 18/04/24
 */
public class Account {
    private int accountNum;
    private int sortCode;
    private String accountOwner;
    private int accountBalance;
    private LocalDate openDate;
    private String status;//Open/Closed
    private LocalDate closureDate;//(If Closed)
    private int closingBalance;//(If Closed)
}
