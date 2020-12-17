package ru.otus;

import ru.otus.handler.ComplexProcessor;
import ru.otus.listener.ListenerPrinter;
import ru.otus.listener.homework.ListenerSaveMsg;
import ru.otus.listener.homework.Originator;
import ru.otus.model.Message;
import ru.otus.model.ObjectForMessage;
import ru.otus.processor.LoggerProcessor;
import ru.otus.processor.homework.ProcessorChange11and12Fields;
import ru.otus.processor.homework.ProcessorError;

import java.util.ArrayList;
import java.util.List;

public class HomeWork {

    /*
     Реализовать to do:
       1. Добавить поля field11 - field13 (для field13 используйте класс ObjectForMessage)
       2. Сделать процессор, который поменяет местами значения field11 и field12
       3. Сделать процессор, который будет выбрасывать исключение в четную секунду (сделайте тест с гарантированным результатом)
            Секунда должна определяьться во время выполнения.
       4. Сделать Listener для ведения истории: старое сообщение - новое (подумайте, как сделать, чтобы сообщения не портились)
     */


    public static void main(String[] args) {

        ObjectForMessage objectForMessage = new ObjectForMessage();
        List <String> data = new ArrayList<>();
        data.add("1 строка");
        data.add("2 строка");
        objectForMessage.setData(data);

        var message = new Message.Builder(1L)
                .field11("field11")
                .field12("field12")
                .field13(objectForMessage)
                .build();

        var processors = List.of(new ProcessorChange11and12Fields(),
                new LoggerProcessor(new ProcessorError()));

        Originator originator = new Originator();

        var complexProcessor = new ComplexProcessor(processors, (ex) -> {});
        var listenerSaveMsg = new ListenerSaveMsg(originator);
        var listenerPrinter = new ListenerPrinter();
        complexProcessor.addListener(listenerPrinter);
        complexProcessor.addListener(listenerSaveMsg);

        var result = complexProcessor.handle(message);
        System.out.println("result:" + result);
        System.out.println();

        System.out.println(originator.restoreState().toString());
        System.out.println();

        result = complexProcessor.handle(result);
        System.out.println("result:" + result);
        System.out.println();

        System.out.println( originator.restoreState().toString());
        System.out.println();

        complexProcessor.removeListener(listenerPrinter);
        complexProcessor.removeListener(listenerSaveMsg);
    }
}
