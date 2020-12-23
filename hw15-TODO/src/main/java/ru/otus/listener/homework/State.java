package ru.otus.listener.homework;

import ru.otus.model.Message;
import ru.otus.model.ObjectForMessage;

import java.util.LinkedList;

/** хранение состояния сообщения **/
public class State {
    private Message oldMsg;
    private Message newMsg;

    State(State state) {
        this.oldMsg = state.oldMsg.clone();
        this.newMsg = state.newMsg.clone();
    }

    public State(Message oldMsg, Message newMsg) {
        this.oldMsg = oldMsg.clone();
        this.newMsg = newMsg.clone();
    }

    @Override
    public String toString() {
        return ":   oldMsg: " + (oldMsg == null ? null :
                oldMsg.toString()) +
                System.lineSeparator()+
                "   newMsg: " + (newMsg == null ? null :
                newMsg.toString());
    }
}