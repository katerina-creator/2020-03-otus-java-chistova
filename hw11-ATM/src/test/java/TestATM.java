import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.otus.chistova.ATM.ATM;
import ru.otus.chistova.ATM.Nominal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
public class TestATM {

    ATM atm;
    private HashMap<Nominal, Integer> putBanknotes;

    private static final int COUNT_1 = 0;
    private static final int COUNT_2 = 0;
    private static final int COUNT_3 = 1;
    private static final int COUNT_4 = 0;
    private static final int COUNT_5 = 2;
    private static final int COUNT_6 = 2;

    private static final int START_BALANCE = 0;
    private static final int TAKE_TRUE_SUM = 14500;
    private static final int TAKE_FALSE_SUM = 20000;

    private static final String EOL = System.lineSeparator();
    private static final String TXT_START_BALANCE = "Balance: "+START_BALANCE;
    private static final String TXT_PUT_MONEY = "Put money: 14500";
    private static final String TXT_ERROR_BALANCE = "Insufficient funds. Please, try later.";
    private static final String TXT_OK_PUT_MONEY =  "The operation was completed successfully. Issued: "+TAKE_TRUE_SUM;

    private PrintStream backup;
    private ByteArrayOutputStream bos;

    @Before
    public void setUp() {
        //Вносимые деньги
        putBanknotes = new HashMap<Nominal, Integer>();

        putBanknotes.put(Nominal.NOMINAL_1, COUNT_1);
        putBanknotes.put(Nominal.NOMINAL_2, COUNT_2);
        putBanknotes.put(Nominal.NOMINAL_3, COUNT_3);
        putBanknotes.put(Nominal.NOMINAL_4, COUNT_4);
        putBanknotes.put(Nominal.NOMINAL_5, COUNT_5);
        putBanknotes.put(Nominal.NOMINAL_6, COUNT_6);


        System.out.println(Thread.currentThread().getName());
        backup = System.out;
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        atm = new ATM(Nominal.NOMINAL_1, Nominal.NOMINAL_2,
                Nominal.NOMINAL_3, Nominal.NOMINAL_4,
                Nominal.NOMINAL_5, Nominal.NOMINAL_6);
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
