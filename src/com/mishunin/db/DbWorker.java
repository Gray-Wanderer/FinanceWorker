package com.mishunin.db;

import com.mishunin.db.entities.BaseEntity;
import com.mishunin.db.entities.annotations.Column;
import com.mishunin.utils.MetaUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author mishunin
 * @version $Id$
 */
public class DbWorker {

    private static DbWorker dbWorker;

    private static final String CLOSE_QUERY = "SHUTDOWN";
    private static final String GET_ENTITY_QUERY = "select * from ? where id = ?";
    private static final String GET_ENTITIES_QUERY = "select * from ?";

    public static DbWorker getInstance() {
        if (dbWorker == null)
            dbWorker = new DbWorker();
        return dbWorker;
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:financeDb", "SA", "");
    }

    public void init() throws SQLException, IOException {
        File file = new File("db/createDb.sql");
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String currentStr;
            while ((currentStr = reader.readLine()) != null) {
                builder.append(currentStr);
            }
        }
        try (Connection connection = getConnection()) {
            if (builder.length() > 0) {
                String[] queries = builder.toString().split("\\^");
                for (String query : queries) {
                    PreparedStatement stm = connection.prepareStatement(query);
                    stm.executeUpdate();
                }
            }
        }
    }

    public static void dropAll() throws SQLException {
    }

    public void close() throws SQLException {
        try (Connection connection = dbWorker.getConnection()) {
            PreparedStatement stm = connection.prepareStatement(CLOSE_QUERY);
            stm.executeUpdate();
        }
    }

    public <T extends BaseEntity> T findEntity(Class<T> entityClass, UUID uuid) throws SQLException {
        try (Connection connection = dbWorker.getConnection()) {
            PreparedStatement stm = connection.prepareStatement(GET_ENTITY_QUERY);
            stm.setString(0, MetaUtils.getTableName(entityClass));
            stm.setString(1, uuid.toString());
            ResultSet resultSet = stm.executeQuery();
            List<Method> methods = MetaUtils.getAllGetters(entityClass, method -> method.getAnnotation(Column.class) != null);
            if (resultSet.next()) {
                T entity = MetaUtils.createNewEntity(entityClass);
                for (Method method : methods) {
                    Column column = method.getAnnotation(Column.class);
                    String columnName = column.value();
                    entity.setValue(MetaUtils.getGetterParamName(method), resultSet.getObject(columnName));
                }
                return entity;
            }
        }
        return null;
    }

    public <T extends BaseEntity> T reloadEntity(T entity) throws SQLException {
        return findEntity((Class<T>) entity.getClass(), entity.getId());
    }

    public <T extends BaseEntity> List<T> findEntities(Class<T> entityClass) throws SQLException {
        List<T> result = new LinkedList<>();
        try (Connection connection = dbWorker.getConnection()) {
            PreparedStatement stm = connection.prepareStatement(GET_ENTITY_QUERY);
            stm.setString(0, MetaUtils.getTableName(entityClass));
            ResultSet resultSet = stm.executeQuery();
            List<Method> methods = MetaUtils.getAllGetters(entityClass, method -> method.getAnnotation(Column.class) != null);
            while (resultSet.next()) {
                T entity = MetaUtils.createNewEntity(entityClass);
                for (Method method : methods) {
                    Column column = method.getAnnotation(Column.class);
                    String columnName = column.value();
                    entity.setValue(MetaUtils.getGetterParamName(method), resultSet.getObject(columnName));
                }
                result.add(entity);
            }
        }
        return null;
    }
}
