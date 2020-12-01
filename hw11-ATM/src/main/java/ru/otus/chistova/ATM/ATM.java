package ru.otus.chistova.ATM;
import java.util.HashMap;

/**
 * В классе банкомата ATM пользователь может создать банкомат, передав в
 * конструктор список номиналов, которые будет поддерживать банкомат.
 *
 * Пользователь может узнать текущий баланс на счету.
 *
 * Пользователь может внести деньги в банкомат. При этом, внесены будут
 * только те номиналы, которые поддерживает банкомат
 *
 * Пользователь может попробовать снять деньги с банкомата
**/
public class ATM {
    public static HashMap<Nominal, Integer> banknotes;
    public static HashMap<Nominal, Integer> putBanknote;

    /** Конструктор класса
     * Создает банкомат, который сможет принимать только те номиналы,
     * которые были переданы в качестве аргументов
     * **/
    public ATM(Nominal...args) {
        banknotes = new HashMap<Nominal, Integer> ();
        for (short i = 0; i<args.length; i++) {
            banknotes.put(args[i],0);
        }
   }

    /** Метод проверки баланса
     * Печатает текущий баланс в консоль
     * **/
    public static void checkBalance(){
        CalcSum balance = new CalcSum(banknotes);
        System.out.println("Balance: " + balance.doOperation());
    }

    /** Метод внесения денег
     * Печатает, сколько денег было принято банкоматом, в соответствии
     * с номиналами купюр, которые принимает банкомат
     *
     * @param putBanknote**/
    public static void putMoney(HashMap<Nominal, Integer> putBanknote) {
        ATM.putBanknote = putBanknote;
        PutMoney put = new PutMoney(banknotes, putBanknote);
        System.out.println("Put money: " + put.doOperation());
    }

    /** Метод получения денег
     * Если операция не удалась, то метод напечатает сообщение о том, что
     * денег недостаточно с предложением попробовать позже.
     * Если операция удалась, то метод напечатает сообщение, что операция прошла
     * успешно, а также выведет сумму снятых денег
     * **/
    public static void takeMoney(int sum) {
        TakeMoney takeMoney = new TakeMoney(banknotes, sum);
        long issue = takeMoney.doOperation();
        if (issue==0) System.out.println("Insufficient funds. Please, try later.");
            else System.out.println("The operation was completed successfully. Issued: " + issue);
    }

}
