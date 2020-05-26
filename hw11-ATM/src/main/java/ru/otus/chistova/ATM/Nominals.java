package ru.otus.chistova.ATM;

public enum Nominals {
    NOMINAL_1(50),
    NOMINAL_2(100),
    NOMINAL_3(500),
    NOMINAL_4(1000),
    NOMINAL_5(5000),
    NOMINAL_6(2000);
    private int nominal;

    Nominals(int nominal) {
        this.nominal = nominal;
    }

    public int getNominal(){ return nominal;}
}
