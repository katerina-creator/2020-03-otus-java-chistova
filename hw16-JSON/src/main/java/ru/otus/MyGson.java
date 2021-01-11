package ru.otus;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonString;
import javax.json.JsonValue;

public class MyGson {
    Class clazz;
     static Field[] fields;

    public String toJson(Object obj) {
        if (obj == null) {
            return null;
        } else {
            this.clazz = obj.getClass();
            fields = this.clazz.getDeclaredFields();
            return "{" + navigateTree(create(obj)) + "}";
        }
    }

    private static JsonObject create(Object obj) {
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        for(int i = 0; i< fields.length; ++i) {
            Field field = fields[i];
            String fieldName = field.getName();

            Object value;
            try {
                value = field.get(obj);
            } catch (IllegalAccessException ex) {
                value = null;
            }
            /** Анализируем тип данных поля и в соответствии с ним формируем jsonObject **/
            if (field.getType().isPrimitive()) {
                jsonObjectBuilder.add(fieldName, (Integer)value);

            } else if (field.getType().isArray()) {
                int[] arrValue = (int[])value;
                JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

                for(int ii = 0; ii < arrValue.length; ++ii) {
                    jsonArrayBuilder.add(arrValue[ii]);
                }
                JsonArray jsonArr = jsonArrayBuilder.build();
                jsonObjectBuilder.add(fieldName, jsonArr);

            } else if (field.getType().isAssignableFrom(ArrayList.class)) {
                ArrayList arrayList = (ArrayList) value;
                JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

                for(int ii = 0; ii < arrayList.size(); ++ii) {
                    jsonArrayBuilder.add((String) arrayList.get(ii));
                }
                JsonArray jsonArr = jsonArrayBuilder.build();
                jsonObjectBuilder.add(fieldName, jsonArr);
            } else {
                jsonObjectBuilder.add(fieldName, String.valueOf(value));
            }
        }

        JsonObject jsonObject = jsonObjectBuilder.build();
        return jsonObject;
    }

    private static String navigateTree(JsonValue tree) {
        StringBuilder buildStr = new StringBuilder();
        switch(tree.getValueType()) {
            case OBJECT:
                JsonObject jsonObject = (JsonObject)tree;
                Iterator itrObj = jsonObject.entrySet().iterator();

                while(itrObj.hasNext()) {
                    Entry<String, JsonValue> entry = (Entry)itrObj.next();

                    buildStr.append("\"");
                    buildStr.append(entry.getKey());
                    buildStr.append("\":");
                    buildStr.append(navigateTree(jsonObject.get(entry.getKey())));

                    if (itrObj.hasNext()) buildStr.append(",");
                }

                break;
            case ARRAY:
                JsonArray array = (JsonArray)tree;
                Iterator itrArr = array.iterator();

                buildStr.append("[");
                while(itrArr.hasNext()) {
                    JsonValue val = (JsonValue)itrArr.next();
                    buildStr.append(navigateTree(val));
                    if (itrArr.hasNext()) buildStr.append(",");
                }
                buildStr.append("]");
                break;

            case STRING:
                JsonString st = (JsonString)tree;
                buildStr.append(st);
                break;
            case NUMBER:
                JsonNumber num = (JsonNumber)tree;
                buildStr.append(num);
                break;
            case TRUE:
            case FALSE:
            case NULL:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + tree.getValueType());
        }
        return buildStr.toString();
    }
}
