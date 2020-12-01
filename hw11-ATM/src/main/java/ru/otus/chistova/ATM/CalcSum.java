package ru.otus.chistova.ATM;

import java.util.HashMap;
import java.util.Map;

public class CalcSum implements Operation  {
    HashMap<Nominal, Integer> banknotes;

    public CalcSum(HashMap<Nominal, Integer> banknotes) {
        this.banknotes = banknotes;
    }

    @Override
    public long doOperation() {
        long sum = 0;
        Nominal key;
        Integer value;
        for (Map.Entry entry: banknotes.entrySet()) {
            key = (Nominal) entry.getKey();
            value = (Integer) entry.getValue();
            sum+= key.getNominal()*value;
        }
        return sum;
    }
}
