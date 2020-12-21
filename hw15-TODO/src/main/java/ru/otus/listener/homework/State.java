package ru.otus.listener.homework;

import ru.otus.model.Message;
import ru.otus.model.ObjectForMessage;

import java.util.LinkedList;

/** хранение состояния сообщения **/
public class State {
    private Message oldMsg;
    private Message newMsg;

    State(State state) {
        ObjectForMessage oldMsgObject = new ObjectForMessage();
        if (state.oldMsg.getField13()!=null) {
            oldMsgObject.setData(state.oldMsg.getField13().getData());
        }

       this.oldMsg = new  Message.Builder(1L).field1(state.oldMsg.getField1())
                .field2(state.oldMsg.getField2())
                .field3(state.oldMsg.getField3())
                .field4(state.oldMsg.getField4())
                .field5(state.oldMsg.getField5())
                .field6(state.oldMsg.getField6())
                .field7(state.oldMsg.getField7())
                .field8(state.oldMsg.getField8())
                .field9(state.oldMsg.getField9())
                .field10(state.oldMsg.getField10())
                .field11(state.oldMsg.getField11())
                .field12(state.oldMsg.getField12())
                .field13(oldMsgObject)
                .build();

        ObjectForMessage newMsgObject = new ObjectForMessage();
        if (state.newMsg.getField13()!=null) {
            oldMsgObject.setData(state.newMsg.getField13().getData());
        }

        this.newMsg = new  Message.Builder(1L).field1(state.newMsg.getField1())
                .field2(state.newMsg.getField2())
                .field3(state.newMsg.getField3())
                .field4(state.newMsg.getField4())
                .field5(state.newMsg.getField5())
                .field6(state.newMsg.getField6())
                .field7(state.newMsg.getField7())
                .field8(state.newMsg.getField8())
                .field9(state.newMsg.getField9())
                .field10(state.newMsg.getField10())
                .field11(state.newMsg.getField11())
                .field12(state.newMsg.getField12())
                .field13(newMsgObject)
                .build();
    }

    public State(Message oldMsg, Message newMsg) {
        ObjectForMessage oldMsgObject = new ObjectForMessage();
        if (oldMsg.getField13()!=null) {
            oldMsgObject.setData(oldMsg.getField13().getData());
        }
            this.oldMsg = new Message.Builder(1L).field1(oldMsg.getField1())
                    .field2(oldMsg.getField2())
                    .field3(oldMsg.getField3())
                    .field4(oldMsg.getField4())
                    .field5(oldMsg.getField5())
                    .field6(oldMsg.getField6())
                    .field7(oldMsg.getField7())
                    .field8(oldMsg.getField8())
                    .field9(oldMsg.getField9())
                    .field10(oldMsg.getField10())
                    .field11(oldMsg.getField11())
                    .field12(oldMsg.getField12())
                    .field13(oldMsgObject)
                    .build();

           // System.err.println(oldMsgObject.toString());

        ObjectForMessage newMsgObject = new ObjectForMessage();
        if (newMsg.getField13()!=null) {
            newMsgObject.setData(newMsg.getField13().getData());
        }

        this.newMsg = new  Message.Builder(1L).field1(newMsg.getField1())
                .field2(newMsg.getField2())
                .field3(newMsg.getField3())
                .field4(newMsg.getField4())
                .field5(newMsg.getField5())
                .field6(newMsg.getField6())
                .field7(newMsg.getField7())
                .field8(newMsg.getField8())
                .field9(newMsg.getField9())
                .field10(newMsg.getField10())
                .field11(newMsg.getField11())
                .field12(newMsg.getField12())
                .field13(newMsgObject)
                .build();

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
