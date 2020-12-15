package ru.otus.listener.homework;

import ru.otus.model.Message;

import java.util.ArrayList;
import java.util.List;

/** хранение состояния сообщения **/
public class State {
    List<Message> listMsg;

    State(State state) {
        listMsg = state.listMsg;
    }

    State(Message oldMsg, Message newMsg) {
        listMsg = new ArrayList<>();
        listMsg.add(oldMsg);
        listMsg.add(newMsg);
    }

    List<Message> getUpdateHistory() {
        return listMsg;
    }

    @Override
    public String toString() {
        return ": " + (listMsg == null ? null :
                     listMsg.toString()) ;
    }
}
