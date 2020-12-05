package ru.otus.chistova.ATM;

/**
Класс ячейки
Определяется номиналом принимаемой этой ячейкой банкноты и количеством банкнот в ячейке.
**/
public class Cell {
    int nominal;
    int countBanknotes=0;

    public Cell(Nominal nominal, int countBanknotes  ) {
        this.nominal = nominal.getNominal();
        this.countBanknotes = countBanknotes;
    }

    /** Метод получения денег**/
    public long getSum(long sumIssue) {
       int sum = nominal*countBanknotes;
       if (sum>=sumIssue) {
           countBanknotes = 0;
           return sum;
       } else {
           int count = (int) (sumIssue/nominal);
           countBanknotes -= count;
           return count*nominal;
       }
    }

    /** Метод внесения денег**/
    public void addBanknotes(int countBanknotes) {
        this.countBanknotes += countBanknotes;
    }
}