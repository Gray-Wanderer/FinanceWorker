package com.mishunin.db;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author mishunin
 * @version $Id$
 */
public class DbConnectionSingleton {

    private static DbConnectionSingleton dbConnectionSingleton;

    private static final String CLOSE_QUERY = "SHUTDOWN";

    public static DbConnectionSingleton getInstance() {
        if (dbConnectionSingleton == null)
            dbConnectionSingleton = new DbConnectionSingleton();
        return dbConnectionSingleton;
    }

    private Connection connection;

    private Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:hsqldb:file:financeDb", "SA", "");
        }
        return connection;
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
        if (builder.length() > 0) {
            String[] queries = builder.toString().split("\\^");
            for (String query : queries) {
                PreparedStatement stm = getConnection().prepareStatement(query);
                stm.executeUpdate();
            }
        }
    }

    public static void dropAll() throws SQLException {
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            try {
                PreparedStatement stm = connection.prepareStatement(CLOSE_QUERY);
                stm.executeUpdate();
            } finally {
                connection.close();
            }
        }
    }

}
