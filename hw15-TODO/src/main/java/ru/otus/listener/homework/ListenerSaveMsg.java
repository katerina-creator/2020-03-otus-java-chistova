package ru.otus.listener.homework;

import ru.otus.listener.Listener;
import ru.otus.model.Message;

/** Слушатель, делающий копию состояния сообщения **/

public class ListenerSaveMsg implements Listener {
    @Override
    public void onUpdated(Message oldMsg, Message newMsg) {
            Originator originator = new Originator();
            State stateMsg = new State(oldMsg, newMsg);
            originator.saveState(stateMsg);
            System.out.println("Saved state"+ stateMsg);
    }
}
