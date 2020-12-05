package ru.otus.chistova.ATM;

public class CalcSum implements Operation  {
    Cell[] cells;

    public CalcSum(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public long doOperation() {
       long sum = 0;
        for (Cell cell:cells){
            sum+=cell.nominal*cell.countBanknotes;
        }
        return sum;
    }
}
