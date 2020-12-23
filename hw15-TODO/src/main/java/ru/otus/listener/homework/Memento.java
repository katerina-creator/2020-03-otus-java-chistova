package ru.otus.listener.homework;

import java.time.LocalDateTime;

/** Снимок состояния **/
class Memento {
    private final State state;
    private final LocalDateTime dateTime;

    Memento(State state, LocalDateTime dateTime) {
        this.state = new State(state);
        this.dateTime = dateTime;

    }

    LocalDateTime getDateTime() {
        return dateTime;
    }

    State getState() {
        return state;
    }

}