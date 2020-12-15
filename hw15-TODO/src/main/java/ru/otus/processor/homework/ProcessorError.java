package ru.otus.processor.homework;

import ru.otus.model.Message;
import ru.otus.processor.Processor;

import java.util.Date;

public class ProcessorError implements Processor  {

    @Override
    public Message process(Message message) {
        Date date = new Date();
        if (date.getSeconds()%2==0)
            throw new NullPointerException("Every even second...");
            //System.out.println("Err");
        return message;
    }
}
