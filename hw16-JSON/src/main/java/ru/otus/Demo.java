package ru.otus;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Demo {
    public Demo() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{55, 66, 77};
        ArrayList list = new ArrayList<>();
        list.add("first");
        list.add("second");

        Gson gson = new Gson();
        AnyObject obj = new AnyObject(22, "test", arr, list);
        String json = gson.toJson(obj);
        System.out.println("  Gson:" + json);

        MyGson myGson = new MyGson();
        String myJson = myGson.toJson(obj);

        System.out.println("MyGson:" + myJson);
        AnyObject obj2 = gson.fromJson(myJson, AnyObject.class);
        System.out.println(obj.equals(obj2));
    }
}
