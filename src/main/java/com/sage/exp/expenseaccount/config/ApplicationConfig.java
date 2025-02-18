package com.sage.exp.expenseaccount.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = { "com.sage.exp.expenseaccount",})
public class ApplicationConfig {
    @Value("${datasource.url}")
    private String dbUrl;

    @Value("${datasource.username}")
    private String dbUsername;

    @Value("${datasource.password}")
    private String dbPassword;


    public ApplicationConfig() {}


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
