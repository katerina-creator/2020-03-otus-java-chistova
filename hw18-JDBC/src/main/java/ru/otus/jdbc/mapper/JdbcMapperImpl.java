package ru.otus.jdbc.mapper;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class JdbcMapperImpl<T extends Object> implements JdbcMapper{
    EntityClassMetaDataImpl metaData;
    EntitySQLMetaData sqlMetaData;
    String sqlStr;

    List<Object> listParam = new ArrayList<>();

    public JdbcMapperImpl(Class<T> clazz){
        metaData= new EntityClassMetaDataImpl(clazz);
    }

    @Override
    public void insert(Object objectData) {
        sqlMetaData = new EntitySQLMetaDataImpl(metaData, objectData);
        sqlStr = sqlMetaData.getInsertSql();
    }

    @Override
    public void update(Object objectData) {

    }

    @Override
    public void insertOrUpdate(Object objectData) {

    }

    @Override
    public Object findById(Object id, Class clazz) {
        sqlMetaData = new EntitySQLMetaDataImpl(metaData, id, clazz);
        sqlStr = sqlMetaData.getSelectByIdSql();

        return null;
    }

    public String getSQL(){
        return sqlStr;
    }

    public List<Object> getParam(){
        Class<?> cls = metaData.getClass();
        Constructor[] constructors = cls.getConstructors();
        for (Constructor constructor : constructors) {
            Class<?>[] params = constructor.getParameterTypes();
            for (Class<?> param : params) {
                listParam.add(param);
            }
        }
        return listParam;
    }
}
