package ru.otus.chistova.ATM;

public class TakeMoney implements Operation  {
    long sum=0;
    Cell[] atm;

    public TakeMoney(Cell[] atm, Integer sum) {
        this.atm = atm;
        this.sum = sum;
    }

    @Override
    public long doOperation() {
        CalcSum balance = new CalcSum(atm);
        if ( balance.doOperation() < sum) return 0;
        else {
            long issue =takeBanknotFromCell(atm[atm.length-1],atm.length-1, sum);
            return issue;
        }
    }

    public long takeBanknotFromCell(Cell cell, int curIndex, long gettingSum){
        long curSum = cell.getSum(gettingSum);
        if (gettingSum<=curSum) return gettingSum;
            else return curSum+takeBanknotFromCell(atm[curIndex-1], curIndex-1, gettingSum-curSum);

    }
}
