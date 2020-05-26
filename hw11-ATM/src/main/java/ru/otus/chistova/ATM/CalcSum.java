package ru.otus.chistova.ATM;

import java.util.HashMap;
import java.util.Map;

public class CalcSum implements Operation  {
    HashMap<Integer, Integer> banknotes;

    public CalcSum(HashMap<Integer, Integer> banknotes) {
        this.banknotes = banknotes;
    }

    @Override
    public long doOperation() {
        long sum = 0;
        Integer key;
        Integer value;
        for (Map.Entry entry: banknotes.entrySet()) {
            key = (Integer) entry.getKey();
            value = (Integer) entry.getValue();
            sum+= key*value;
        }
        return sum;
    }
}
