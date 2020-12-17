package ru.otus.listener.homework;

import ru.otus.model.Message;

import java.util.LinkedList;

/** хранение состояния сообщения **/
public class State {
    private final LinkedList<Message> listMsg;

    State(State state) {
        listMsg = state.listMsg;
    }

    public State(Message oldMsg, Message newMsg) {
        listMsg = new LinkedList<>();
        listMsg.add(oldMsg);
        listMsg.add(newMsg);
    }

    @Override
    public String toString() {
        return ": " + (listMsg == null ? null :
                     listMsg.toString()) ;
    }
}
