package ru.otus.chistova.ATM;

import java.util.*;

public class TakeMoney implements Operation  {
    HashMap<Integer, Integer> banknotes;
    TreeMap<Integer, Integer> treeBanknotes;
    HashMap<Integer, Integer> issue;
    Integer sum=0;

    public TakeMoney(HashMap<Integer, Integer> banknotes, Integer sum) {
        this.banknotes = banknotes;
        this.sum = sum;
        //Сортируем HashMap по убыванию в treeBanknotes
        treeBanknotes = new TreeMap<>(Collections.reverseOrder());
        treeBanknotes.putAll(banknotes);
    }

    @Override
    public long doOperation() {
        CalcSum balance = new CalcSum(banknotes);
        //Если денег в банкомате меньше запрашиваемой суммы, возвращаем 0
        if ( balance.doOperation() < sum) return 0;
        else {
            //Запускаем метод расчета выдачи
            issue = doIssue();
            if (issue==null) return 0;
            CalcSum issueBalance = new CalcSum(issue);
            long issueSum= issueBalance.doOperation();
            return issueSum;
        }
  }
    //Метод расчета выдачи
    public HashMap<Integer, Integer> doIssue() {
        HashMap<Integer, Integer> tmpIssue = new HashMap<>();
        int findSum = sum;
        for (Map.Entry entry: treeBanknotes.entrySet()) {
            Integer nominal = (Integer) entry.getKey();
            int count = treeBanknotes.get(nominal);

            int i=1;
            //Перебираем количество банкнот в ячейке, если они там есть
            if (count>0) {
                while (i <= count) {
                    long takeSum = nominal * i;
                    //Если сумма не набрана, но купюры кончились
                    if ((takeSum <= findSum) && (i == count)) {
                        tmpIssue.put(nominal, i);
                        findSum -= takeSum;
                        break;
                    }
                    //Если взята лишняя купюра, выдаем из ячейки на 1 меньше и уменьшаем сумму выдачи на 1 номинал
                    if (takeSum > findSum) {
                        tmpIssue.put(nominal, i - 1);
                        findSum -= takeSum - nominal;
                        break;
                    }

                    //Если сумма не набрана и еще есть купюры, берем следующую купюру
                //    if ((takeSum < findSum) && (i < count))
                        i++;
                }
            }
            //Если вся сумма найдена, выходим
            if (findSum==0) {return tmpIssue;}
            }
        return null;
        }

        //Напечатать результат выдачи
        public String printIssue(){
        String issueRezult="";
            for (Map.Entry entry: issue.entrySet()) {
                Integer nominal = (Integer) entry.getKey();
                int count = (int) entry.getValue();
                if (count>0)
                issueRezult += String.valueOf(count)+" по "+String.valueOf(nominal)+"\n";
            }
            return issueRezult;
        }

}
