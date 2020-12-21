package ru.otus.processor.homework;


import ru.otus.model.Message;
import ru.otus.processor.Processor;

public class ProcessorChange11and12Fields  implements Processor {
    @Override
    public Message process(Message message) {
        Message newMessage = new Message.Builder(1L)
                .field11(message.getField12())
                .field12(message.getField11())
                .build();
        return newMessage;
    }
}
