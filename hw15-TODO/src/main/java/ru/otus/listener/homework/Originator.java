package ru.otus.listener.homework;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;

/** Создатель снимков **/
public class Originator {
    private final Deque<Memento> stackMsgState = new ArrayDeque<>();
    private final LocalDateTime dateTime;

    public Originator() {
        dateTime = LocalDateTime.now();
    }

    public void saveState(State state) {
        stackMsgState.push(new Memento(state, dateTime));
        System.out.println("Save copy at: " + dateTime);
    }

    public State restoreState() {
        var memento = stackMsgState.pop();
        System.out.println("Get copy:" + memento.getDateTime());
        return memento.getState();
    }


}
