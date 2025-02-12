package com.sage.exp.expenseaccount.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseUtil {

    private static DatabaseUtil instance;
    private static String DB_URL;
    private static String DB_USER;
    private static String DB_PASSWORD;

    public DatabaseUtil(){
        loadProperties();
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(DatabaseUtil.class.getClassLoader().getResourceAsStream("application.properties.example"));
            DB_URL = properties.getProperty("db.url");
            DB_USER = properties.getProperty("db.user");
            DB_PASSWORD = properties.getProperty("db.password");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }

    private void initDatabase() {
        try(Connection conn = getConnection();
            Statement statement = conn.createStatement()) {
            String schema = new String(Files.readAllBytes(Paths.get("src/main/resources/init.sql")));
            String[] queries = schema.split(";");
            for (String query : queries){
                if(!query.trim().isEmpty()){
                    statement.execute(query.trim());
                }
            }

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
