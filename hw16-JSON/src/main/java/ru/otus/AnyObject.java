package ru.otus;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AnyObject {
     int field1;
     String field2;
     int[] field3;
     ArrayList field4;

    public AnyObject(int field1, String field2, int[] field3, ArrayList field4) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }

    public int getField1() {
        return this.field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return this.field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public int[] getField3() {
        return this.field3;
    }

    public void setField3(int[] field3) {
        this.field3 = field3;
    }

    public ArrayList getField4() {
        return this.field4;
    }

    public void setField4(ArrayList field4) { this.field4 = field4; }

    public boolean equals(Object object) {
        AnyObject anyObject = (AnyObject) object;
        if (this.field1!=anyObject.getField1()) return false;

        if (!this.field2.equals(anyObject.getField2())) return false;

        for (int i=0; i<this.field3.length; i++){
            if (field3[i]!=anyObject.getField3()[i])  return false;
        }

        for (int i=0; i<this.field4.size(); i++){
            if (!field4.get(i).equals(anyObject.getField4().get(i)))  return false;
        }
            return true;
    }
}
