import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.otus.chistova.ATM.ATM;
import ru.otus.chistova.ATM.Cell;
import ru.otus.chistova.ATM.Nominal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
public class TestATM {

    private static final int COUNT_BANKNOTE_50 = 0;
    private static final int COUNT_BANKNOTE_100 = 0;
    private static final int COUNT_BANKNOTE_500 = 1;
    private static final int COUNT_BANKNOTE_1000 = 0;
    private static final int COUNT_BANKNOTE_2000 = 2;
    private static final int COUNT_BANKNOTE_5000 = 2;

    private static final int START_BALANCE = 0;
    private static final int CUR_BALANCE = 14500;
    private static final int TAKE_TRUE_SUM = 2500;
    private static final int TAKE_FALSE_SUM = 13000;

    private static final String EOL = System.lineSeparator();
    private static final String TXT_START_BALANCE = "Balance: "+START_BALANCE;
    private static final String TXT_AFTER_PUT_BALANCE = "Balance: "+CUR_BALANCE;
    private static final String TXT_PUT_MONEY = "Put money: 14500";
    private static final String TXT_ERROR_BALANCE = "Insufficient funds. Please, try later.";
    private static final String TXT_OK_PUT_MONEY =  "The operation was completed successfully. Issued: "+TAKE_TRUE_SUM;

    ATM atm = new ATM(Nominal.NOMINAL_1, Nominal.NOMINAL_2,
                    Nominal.NOMINAL_3, Nominal.NOMINAL_4,
                    Nominal.NOMINAL_5, Nominal.NOMINAL_6);

    Cell[] putBanknotes = {new Cell(Nominal.NOMINAL_1,COUNT_BANKNOTE_50),
                           new Cell(Nominal.NOMINAL_2,COUNT_BANKNOTE_100),
                           new Cell(Nominal.NOMINAL_3,COUNT_BANKNOTE_500),
                           new Cell(Nominal.NOMINAL_4,COUNT_BANKNOTE_1000),
                           new Cell(Nominal.NOMINAL_5,COUNT_BANKNOTE_2000),
                           new Cell(Nominal.NOMINAL_6,COUNT_BANKNOTE_5000)
    };

    private PrintStream backup;
    private ByteArrayOutputStream bos;

    @Before
    public void setUp() {
        System.out.println(Thread.currentThread().getName());
        backup = System.out;
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
    }

    @AfterEach
    void tearDown() {
        System.setOut(backup);
    }

    @Test
    public void checkBalanceWhenCreateATM(){
       atm.checkBalance();
        assertThat(bos.toString()).isEqualTo(TXT_START_BALANCE + EOL);
    }

    @Test
    public void putMoney(){
        atm.putMoney(putBanknotes);
        assertThat(bos.toString()).isEqualTo(TXT_PUT_MONEY + EOL);
    }


    @Test
    public void takeMoneyIfTrueBalance(){
        //Предварительно положим денег в банкомат
        atm.putMoney(putBanknotes);
        atm.takeMoney(TAKE_TRUE_SUM);
        assertThat(bos.toString()).isEqualTo(TXT_PUT_MONEY+EOL+TXT_OK_PUT_MONEY+EOL);
    }

    @Test
    public void takeMoneyIfErrorBalance(){
        atm.takeMoney(TAKE_FALSE_SUM);
        assertThat(bos.toString()).isEqualTo(TXT_ERROR_BALANCE + EOL);
    }

}
