package ru.otus.chistova.ATM;

import java.util.HashMap;
import java.util.Map;

public class PutMoney implements Operation {
    HashMap<Nominal, Integer> curBanknotes;
    HashMap<Nominal, Integer> putBanknotes;
    CalcSum acceptBalance;

    public PutMoney(HashMap<Nominal, Integer> curBanknotes, HashMap<Nominal, Integer> putBanknotes) {
        this.curBanknotes = curBanknotes;
        this.putBanknotes = putBanknotes;
    }

    @Override
    public long doOperation() {
        //Перебираем все входящие банкноты
            for (Map.Entry putEntry: putBanknotes.entrySet()) {
                Object putKey = putEntry.getKey();
                //Если есть ячейка для таких банкнот
                if (curBanknotes.containsKey(putKey)) {
                    int sumBanknotes = curBanknotes.get(putKey)+putBanknotes.get(putKey);
                        curBanknotes.put((Nominal) putKey, sumBanknotes);
                }
            }
        //Считаем сумму внесенных банкнот
        acceptBalance = new CalcSum(curBanknotes);
        return  (acceptBalance.doOperation());
    }

}
