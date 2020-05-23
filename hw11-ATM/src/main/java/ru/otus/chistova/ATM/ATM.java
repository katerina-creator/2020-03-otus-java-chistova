package ru.otus.chistova.ATM;
import java.util.HashMap;

/*
 Класс банкомата
*/
public class ATM {
    public static HashMap<Short, Integer> banknotes;
    public static HashMap<Short, Integer> putBanknote;
    private static final short NOMINAL_1 = 50;
    private static final short NOMINAL_2 = 100;
    private static final short NOMINAL_3 = 500;
    private static final short NOMINAL_4 = 1000;
    private static final short NOMINAL_5 = 5000;

    public ATM() {
        //Создаем список банкнот
        banknotes = new HashMap<Short, Integer> ();
        banknotes.put(NOMINAL_1, 0);
        banknotes.put(NOMINAL_2, 0);
        banknotes.put(NOMINAL_3, 0);
        banknotes.put(NOMINAL_4, 0);
        banknotes.put(NOMINAL_5, 0);
   }

    public static void checkBalance(){
        CalcSum balance = new CalcSum(banknotes);
        System.out.println("Balance: " + balance.doOperation());
    }

    public static void putMoney(HashMap<Short, Integer> putBanknote) {
        ATM.putBanknote = putBanknote;
        PutMoney put = new PutMoney(banknotes, putBanknote);
        System.out.println("Put money: " + put.doOperation());
    }

    public static void takeMoney(int sum) {
        TakeMoney takeMoney = new TakeMoney(banknotes, sum);
        long issue = takeMoney.doOperation();
        if (issue==0) System.out.println("Insufficient funds. Please, try later.");
            else System.out.println("The operation was completed successfully. Issued: " + issue);
    }

}
