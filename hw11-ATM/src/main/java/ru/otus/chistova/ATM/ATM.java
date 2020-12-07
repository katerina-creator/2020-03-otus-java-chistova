package ru.otus.chistova.ATM;
/**
 * В классе банкомата ATM пользователь может создать банкомат, передав в
 * конструктор список номиналов, которые будет поддерживать банкомат.
 *
 * Пользователь может узнать текущий баланс на счету.
 *
 * Пользователь может попробовать снять деньги с банкомата
**/
public class ATM {
    public static Cell[] atm;
    static Cell[] putBanknotes;

    public ATM(Nominal...args) {
        int countCell = args.length;
        atm = new Cell[countCell];

        // Создаем ячейку под каждый номинал с начальным количеством 0 банкнот
        for (int i=0; i<args.length;i++){
            atm[i]=new Cell(args[i], 0);
        }
   }

    /** Метод проверки баланса
     * Печатает текущий баланс в консоль
     * **/
    public static void checkBalance(){
        CalcSum balance = new CalcSum(atm);
        System.out.println("Balance: " + balance.doOperation());
    }

    /** Метод внесения денег
     * Печатает, сколько денег было принято банкоматом, в соответствии
     * с номиналами купюр, которые принимает банкомат
     *
     * @param putBanknotes**/
    public static void putMoney(Cell [] putBanknotes) {
        ATM.putBanknotes = putBanknotes;
        PutMoney put = new PutMoney(atm, putBanknotes);
        System.out.println("Put money: " + put.doOperation());
    }

    /** Метод получения денег
     * Если операция не удалась, то метод напечатает сообщение о том, что
     * денег недостаточно с предложением попробовать позже.
     * Если операция удалась, то метод напечатает сообщение, что операция прошла
     * успешно, а также выведет сумму снятых денег
     * **/
    public static void takeMoney(int sum) {
        TakeMoney takeMoney = new TakeMoney(atm, sum);
        long issue = takeMoney.doOperation();
        if (issue==0) System.out.println("Insufficient funds. Please, try later.");
            else System.out.println("The operation was completed successfully. Issued: " + issue);


    }

}
