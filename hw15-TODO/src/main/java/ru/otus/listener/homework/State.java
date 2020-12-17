package ru.otus.listener.homework;

import ru.otus.model.Message;

import java.util.LinkedList;

/** хранение состояния сообщения **/
public class State {
    private final Message oldMsg;
    private final Message newMsg;

    State(State state) {
        oldMsg = state.oldMsg;
        oldMsg.toBuilder().field13(state.oldMsg.getField13()).build();
        newMsg = state.newMsg;
        newMsg.toBuilder().field13(state.newMsg.getField13()).build();
    }

    public State(Message oldMsg, Message newMsg) {
        this.oldMsg=oldMsg;
        oldMsg.toBuilder().field13(oldMsg.getField13()).build();
        this.newMsg=newMsg;
        newMsg.toBuilder().field13(newMsg.getField13()).build();

    }

    @Override
    public String toString() {
        return ": oldMsg: " + (oldMsg == null ? null :
                oldMsg.toString()) +
                "   newMsg: " + (newMsg == null ? null :
                newMsg.toString());
    }
}
