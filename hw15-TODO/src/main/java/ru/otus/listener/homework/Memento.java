package ru.otus.listener.homework;

/** Снимок состояния **/
class Memento {
    private final State state;

    Memento(State state) {
        this.state = new State(state);
    }

    State getState() {
        return state;
    }

}