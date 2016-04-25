package com.mishunin.db;

import com.mishunin.db.entities.BaseEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author mishunin
 * @version $Id$
 */
public class DbWorker {

    private static DbWorker dbWorker;

    private static final String CLOSE_QUERY = "SHUTDOWN";

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

    public void loadEntity(Class<BaseEntity> entityClass, UUID uuid) {

    }

}
