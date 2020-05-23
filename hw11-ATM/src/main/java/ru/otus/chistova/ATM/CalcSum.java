package ru.otus.chistova.ATM;

import java.util.HashMap;
import java.util.Map;

public class CalcSum implements Operation  {
    HashMap<Short, Integer> banknotes;

    public CalcSum(HashMap<Short, Integer> banknotes) {
        this.banknotes = banknotes;
    }

    @Override
    public long doOperation() {
        long sum = 0;
        Short key;
        Integer value;
        for (Map.Entry entry: banknotes.entrySet()) {
            key = (Short) entry.getKey();
            value = (Integer) entry.getValue();
            sum+= key*value;
        }
        return sum;
    }
}
