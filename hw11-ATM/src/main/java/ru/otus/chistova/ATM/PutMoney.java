package ru.otus.chistova.ATM;

public class PutMoney implements Operation {
    Cell[] atm;
    Cell[] putBanknotes;
    CalcSum acceptBalance;

    public PutMoney(Cell[] atm, Cell[] putBanknotes) {
        this.atm = atm;
        this.putBanknotes = putBanknotes;
    }

    @Override
    public long doOperation() {
        for (int i=0; i<putBanknotes.length-1; i++){
            atm[i].addBanknotes(putBanknotes[i].countBanknotes);
        }
        acceptBalance = new CalcSum(putBanknotes);
        return  (acceptBalance.doOperation());
    }

}
