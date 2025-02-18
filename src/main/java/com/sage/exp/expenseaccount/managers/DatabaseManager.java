package com.sage.exp.expenseaccount.managers;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.sage.exp.expenseaccount.models.Admin;
import com.sage.exp.expenseaccount.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class DatabaseManager {

    private ApplicationConfig props;
    private ConnectionSource connectionSource;

    @Autowired
    public DatabaseManager(ApplicationConfig props) {
        this.props = props;
        initDatabase();
    }

    private void initDatabase() {
        try {
            connectionSource = new JdbcConnectionSource(props.getDbUrl(), props.getDbUsername(), props.getDbPassword());
            TableUtils.createTableIfNotExists(connectionSource, Admin.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public ConnectionSource getConnection() throws SQLException {
        return connectionSource;
    }
}
