package ru.otus.listener.homework;

import java.util.ArrayDeque;
import java.util.Deque;

/** Создатель снимков **/
public class Originator {
    private final Deque<Memento> stackMsgState = new ArrayDeque<>();

    void saveState(State state) {
        stackMsgState.push(new Memento(state));
    }

    State restoreState() {
        var memento = stackMsgState.pop();
        return memento.getState();
    }


}
