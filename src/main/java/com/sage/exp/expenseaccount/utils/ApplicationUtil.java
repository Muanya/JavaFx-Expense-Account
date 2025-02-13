package com.sage.exp.expenseaccount.utils;

import java.io.IOException;
import java.util.Properties;

public class ApplicationUtil {
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;


    public ApplicationUtil() {
        loadProperties();
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ApplicationUtil.class.getClassLoader().getResourceAsStream("application.properties"));

            // set properties
            dbUrl = properties.getProperty("datasource.url");
            dbUsername = properties.getProperty("datasource.username");
            dbPassword = properties.getProperty("datasource.password");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }
}
