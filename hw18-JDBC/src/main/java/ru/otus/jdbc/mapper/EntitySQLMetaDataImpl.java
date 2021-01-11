package ru.otus.jdbc.mapper;

import java.lang.reflect.Field;

public class EntitySQLMetaDataImpl implements EntitySQLMetaData{
    EntityClassMetaData metaData;
    Object objectData;
    Class clazz;
    Object id;

    public EntitySQLMetaDataImpl(EntityClassMetaData metaData, Object objectData) {
        this.metaData = metaData;
        this.objectData = objectData;
    }

    public EntitySQLMetaDataImpl(EntityClassMetaData metaData, Object id, Class clazz) {
        this.metaData = metaData;
        this.id = id;
        this.clazz = clazz;
    }

    @Override
    public String getSelectAllSql() {
        Class clazz = metaData.getClass();
        StringBuilder sqlSelectAll = new StringBuilder();
        sqlSelectAll.append("SELECT * FROM ");
        sqlSelectAll.append(clazz.getSimpleName());
        return sqlSelectAll.toString();
    }

    @Override
    public String getSelectByIdSql() {
        StringBuilder sqlSelectAll = new StringBuilder();
        sqlSelectAll.append("SELECT * FROM ");
        sqlSelectAll.append(clazz.getSimpleName());
        sqlSelectAll.append(" WHERE id = ");
        sqlSelectAll.append(id);
        return sqlSelectAll.toString();
    }

    @Override
    public String getInsertSql() {
        Class clazz = objectData.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder sqlInsert = new StringBuilder();
        sqlInsert.append( "INSERT INTO ")
                .append(clazz.getSimpleName())
                .append(" VALUES (");

        for (int i=0; i<fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                if (fields[i].getType().equals(String.class)) {
                    sqlInsert.append("\'");
                    sqlInsert.append(fields[i].get(objectData));
                    sqlInsert.append("\'");
                } else
                sqlInsert.append(fields[i].get(objectData));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (i != fields.length - 1)
                sqlInsert.append(", ");
        }
        sqlInsert.append(")");

        return sqlInsert.toString();
    }

    @Override
    public String getUpdateSql() {
        return null;
    }
}
