package ru.otus.jdbc.mapper;

import ru.otus.core.model.id;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EntityClassMetaDataImpl implements EntityClassMetaData{
        private final Class clazz;

        public EntityClassMetaDataImpl(Class clazz) {
            this.clazz = clazz;
        }

    @Override
    public String getName() {
        return clazz.getName();
    }

    @Override
    public Constructor getConstructor() {
        try {
            return clazz.getConstructor();
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    @Override
    public Field getIdField() {
        Field[] allFields = clazz.getDeclaredFields();
        for(Field field: allFields){
            System.out.println(field.getAnnotatedType());
            if (field.isAnnotationPresent(id.class)) return field;
        }
        return null;
    }

    @Override
    public List<Field> getAllFields() {
        Field[] allFields = clazz.getDeclaredFields();
        List<Field>listField = new ArrayList<>();
        for(Field field: allFields){
            listField.add(field);
        }
        return listField;
    }

    @Override
    public List<Field> getFieldsWithoutId() {
        Field[] allFields = clazz.getDeclaredFields();
        List<Field>listField = new ArrayList<>();
        /** Добавляем те поля, которые не имеют аннотации @id **/
        for(Field field: allFields){
            if (!field.isAnnotationPresent(id.class))  listField.add(field);
        }
        return listField;
    }

}
